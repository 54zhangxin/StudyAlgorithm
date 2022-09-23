package 链表;

/**
 * 题目详情：https://leetcode-cn.com/problems/merge-two-sorted-lists/
 * 将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
 *
 * 简单
 */
public class 合并两个有序链表 {

    //递归法
    public ListNode mergeTwoList(ListNode l1, ListNode l2) {

        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }

        if (l1.val < l2.val) {
            l1.next = mergeTwoList(l1.next, l2);
            return  l1;
        }else {
            l2.next = mergeTwoList(l1, l2.next);
            return l2;
        }
    }
}
