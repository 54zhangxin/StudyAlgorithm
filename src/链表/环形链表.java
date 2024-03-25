package 链表;

/**
 * https://leetcode.cn/problems/linked-list-cycle/
 * easy
 * 题目：给你一个链表的头节点 head ，判断链表中是否有环。
 * 思路：快慢指针
 * 算法步骤：
 * 1、慢指针和快指针两个指针初始化均指向头结点
 * 2、循环遍历慢指针和快指针，每次让慢指针移动一步，快指针移动两步，当一个链表有环时，两个指针会陷入无限循环中，然后变成了追及问题，
 *    只要一直移动下去，快指针总会追上慢指针。
 * 3、如果 快指针 == 慢指针 即结束循环
 *.
 * 复杂度分析：
 * 时间复杂度 O(N)：N 为链表节点数量
 * 空间复杂度 O(1)：占用常数大小的空间
 */
public class 环形链表 {

    public boolean hasCycle(ListNode head) {
        //一定要注意这个边界的判断
        if (head == null || head.next == null) {
            return false;
        }
        ListNode slow = head;
        //快指针，初始在头节点下一个位置【为了进入循环，快慢指针初始不在一个位置】
        //这里让快慢指针一样指向head 都可以
        ListNode fast = head.next;
        while (slow != fast) {
            if (fast == null || fast.next == null) {
                return false;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        return true;

    }
}
