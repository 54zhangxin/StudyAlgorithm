package 链表;

/**
 * https://leetcode-cn.com/problems/reverse-linked-list/
 */
public class 翻转链表 {
    //迭代

    /**
     *   null   a  ->  b  ->  c
     *   pre   cur
     *
     */
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode prev = null;
        ListNode cur = head;
        while (cur != null) {
            //把当前节点的next 节点 存着
            ListNode next = cur.next;
            //把当前节点的next 指向前一位节点
            cur.next = prev;
            //默认的前节点向后移动
            prev = cur;
            //当前节点 也想后移动
            cur = next;
        }

        return prev;
    }

    /**
     * https://leetcode.cn/problems/reverse-linked-list/solution/dong-hua-yan-shi-206-fan-zhuan-lian-biao-by-user74/
     * 递归解法 看图就容易理解了
     *
     * reverseList: head=1
     *     reverseList: head=2
     * 	       reverseList: head=3
     * 		       reverseList:head=4
     * 			       reverseList:head=5
     * 					     终止返回
     * 				   cur = 5
     * 			   4.next.next->4，即5->4
     * 			       cur=5
     * 		   3.next.next->3，即4->3
     * 		         cur = 5
     * 	    2.next.next->2，即3->2
     * 	          cur = 5
     * 1.next.next->1，即2->1
     *
     * 	最后返回cur
     */
    public ListNode reverseList2(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode newHead = reverseList2(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }

}
