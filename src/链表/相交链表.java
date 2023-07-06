package 链表;

/**
 * https://leetcode.cn/problems/intersection-of-two-linked-lists/
 * easy
 * 题解： 题解有图 可以快速理解
 * https://leetcode.cn/problems/intersection-of-two-linked-lists/solution/intersection-of-two-linked-lists-shuang-zhi-zhen-l/
 * 2个链表分别往前走 A走到末尾null 在下一个变成B
 *                B走到末尾null 在下一个变成A   AB想同时候就是交点
 */
public class 相交链表 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode A = headA, B = headB;
        while (A != B) {
            A = A != null ? A.next : headB;
            B = B != null ? B.next : headA;
        }
        return A;
    }
}
