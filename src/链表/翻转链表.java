package 链表;

/**
 * https://leetcode-cn.com/problems/reverse-linked-list/
 * 链表必会
 */
public class 翻转链表 {
    /**
     *  迭代方式
     *  思路： 先用一个pre 做翻转指向的null
     *   null   a  ->  b  ->  c
     *   pre   cur
     *   null <- a
     *   pre 和 cur 同时向下走一步
     *   最后cur 会变成空节点  pre 会走到原来链表的最后一个节点
     *   需要返回的是： pre
     *
     */
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode prev = null;
        ListNode cur = head;
        while (cur != null) {
            //把当前节点的 next 节点 存着
            ListNode next = cur.next;
            //把当前节点的 next 指向前一位节点
            cur.next = prev;
            //默认的前节点向后移动
            prev = cur;
            //当前节点 也向后移动
            cur = next;
        }

        return prev;
    }

    /**
     * https://leetcode.cn/problems/reverse-linked-list/solution/dong-hua-yan-shi-206-fan-zhuan-lian-biao-by-user74/
     * 递归解法 看图就容易理解了
     * 1 -》 2 -》 3 -》 4 -》5 -》 null
     *第一次进入方法 不满足条件 开始递归
     *   head = 1 即 reverseList(1.next)      reverseList(2)
     *      head = 2 即 reverseList(2.next)    reverseList(3)
     * 	        head = 3 即 reverseList(3.next)  reverseList(4)
     * 		       head = 4 即 reverseList(4.next)  reverseList(5)
     * 	5.next == null 开始终止递归 此时 head = 4 返回的 cur = 5
     * 		       4.next.next = 4   此时 5-》4 4.next = null cur 没变
     * 		    3.next.next -> 3，即 4->3
     * 	    2.next.next->2，即3->2
     * 	          cur = 5
     *   1.next.next->1，即2->1
     * 	最后返回cur
     */
    public ListNode reverseList2(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode cur = reverseList2(head.next);
        head.next.next = head;
        head.next = null;
        return cur;
    }

}
