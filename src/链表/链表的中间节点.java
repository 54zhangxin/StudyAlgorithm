package 链表;

/**
 * https://leetcode.cn/problems/middle-of-the-linked-list/
 * leetcode  876
 * 快慢指针
 * 快指针走2步
 */
public class 链表的中间节点 {
    public ListNode middleNode(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        /**
         * 如果有两个中间节点，
         * 返回第二个中间节点 用 fast != null && fast.next != null
         * 返回第一个用         fast.next!=null && fast.next.next != null
         */
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

}
