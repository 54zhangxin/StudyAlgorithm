package 链表;

/**
 * 题目详情：https://leetcode-cn.com/problems/add-two-numbers/
 * 对于链表问题，返回结果为头结点时，通常需要先初始化一个预先指针 pre，该指针的下一个节点指向真正的头结点head。
 * 使用预先指针的目的在于链表初始化时无可用节点值，而且链表构造过程需要指针移动，进而会导致头指针丢失，无法返回结果。
 *
 * 中等
 * 题目：
 * 输入：l1 = [2,4,3], l2 = [5,6,4]
 * 输出：[7,0,8]
 * 解释：342 + 465 = 807.
 */

public class 两数相加 {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode prev = new ListNode(0);
        ListNode cur = prev;
        int carry = 0;//记录进位
        while (l1 != null || l2 != null) {
            int x = l1 == null ? 0 : l1.val;
            int y = l2 == null ? 0 : l2.val;
            int sum = x + y + carry;

            carry = sum / 10;//获取进位值；
            sum = sum % 10;
            cur.next = new ListNode(sum);
            cur = cur.next;
            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
        }

        if(carry == 1) {//此时为循环结束
            cur.next = new ListNode(carry);
        }

        return prev.next;//返回此是因为 两个点初始化的地址是一样的 后续操作 还是改变了整条链表
    }

}
