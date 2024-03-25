package 链表;

/**
 * https://leetcode.cn/problems/palindrome-linked-list/
 * 请判断一个链表是否为回文链表。
 * easy 标着easy 我感觉不见到 首先找到中间位置 然后去翻转链表
 * 输入: 1->2 输出: false 示例 2:
 * 输入: 1->2->2->1 输出: true
 */
public class 回文链表 {
    //解题思路
    //就是用一个快慢指针，找到链表的中位数节点，然后对后半部分链表进行反转，然后分别从原链表头部和尾部开始遍历判断。
    //寻找回文串的核心思想是从中心向两端扩展：
    boolean isPalindrome(ListNode head) {
        // 这里是让slow 慢指针走到中点
        ListNode slow, fast;
        slow = fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        /**
         * 由于节点总数存在奇数，后续要从slow 指针翻转链表要针对性往下走一步
         *   1    2    3    4    5
         *  s,f
         *        s    f
         *             s         f
         *  这时候的慢指针 s 是中点  为了翻转链表 向下走一位 适配节点总数为偶数的情况
         *
         *  1    2    3     4    5     6
         * s,f
         *       s    f
         *            s          f
         *                  s                f
         */
        if (fast != null){
            slow = slow.next;
        }

        ListNode left = head;
        ListNode right = reverse(slow);
        while (right != null) {
            if (left.val != right.val)
                return false;
            left = left.next;
            right = right.next;
        }

        return true;
    }

    //翻转链表
    ListNode reverse(ListNode head) {
        ListNode pre = null, cur = head;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }
}
