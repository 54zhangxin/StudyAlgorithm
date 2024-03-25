package 链表;

/**
 * https://leetcode.cn/problems/reorder-list/
 * medium
 * 给定一个单链表 L 的头节点 head ，单链表 L 表示为：
 * L0 → L1 → … → Ln - 1 → Ln
 * 请将其重新排列后变为：
 * L0 → Ln → L1 → Ln - 1 → L2 → Ln - 2 → …
 * 不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 */
public class 重排链表 {
    /**
     * 整体思路：
     * 1、快慢指针找到中间节点
     * 2、反转后半段链表
     * 3、合并前半段链表和后半段链表
     * 寻找链表中点(快慢指针) + 链表逆序（反转链表） + 合并链表
     * @param head
     */
    public void reorderList(ListNode head) {
        if (head == null) {
            return;
        }

        // 获得中间节点
        ListNode mid = findMid(head);

        // 中间节点之后的部分进行反转
        ListNode head2 = mid.next;
        mid.next = null;
        head2 = reverseList(head2);

        // 合并
        ListNode head1 = head;
        mergeList(head1, head2);
    }

    // LeetCode 876
    private ListNode findMid(ListNode head){
        ListNode slow = head;
        ListNode fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast= fast.next.next;
        }
        return slow;
    }

    // LeetCode 206
    private ListNode reverseList(ListNode head){
        ListNode prev = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode nextNode = cur.next;
            cur.next = prev;
            prev =cur;
            cur = nextNode;
        }
        return prev;
    }


    private void mergeList(ListNode head1, ListNode head2) {
        ListNode next1 = null;
        ListNode next2 = null;
        while (head1 != null && head2 != null) {
            next1 = head1.next;
            next2 = head2.next;

            head1.next = head2;
            head1 = next1;

            head2.next = head1;
            head2 = next2;
        }
    }
}
