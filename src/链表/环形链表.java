package 链表;

/**
 * https://leetcode.cn/problems/linked-list-cycle/
 * easy
 * 快慢指针
 */
public class 环形链表 {

    public boolean hasCycle(ListNode node) {

        ListNode fastNode = node;
        ListNode slowNode = node;

        while (node.next != null) {
            if (fastNode.next == null) {
                return false;
            }
            fastNode = fastNode.next.next;
            slowNode = slowNode.next;
            if (fastNode == slowNode) {
                return true;
            }
        }
        return false;
    }
}
