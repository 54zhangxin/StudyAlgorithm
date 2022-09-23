package 链表;

/**
 * 给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。
 * 中等
 * 快慢指针
 * 解题思路
 * 就是用快慢指针，快指针quickNode先走n步，然后慢指针slowNode从链表头部出发，每次quickNode和slowNode都只走一步，
 * 直到快指针quickNode走到最后一步，此时slowNode与quickNode之间相差n步，其实是此时slowNode是倒数第n+1个节点，
 * 也就是要删除的节点的前一个节点，直接将slowNode.next = slowNode.next.next;，就可以将节点删除。
 *
 * 但是需要考虑到如果删除的是头结点，此时会比较麻烦，严格意义上，m个节点，头结点与最后一个节点之间只存在m-1个节点的间隔，
 * 也就是只能走m-1步，所以解决方案就是先建一个临时节点加在头结点前面，这样就可以走出m步了，也就是可以删除倒数第m个节点，也就是头结点了。
 */
public class 删除链表的倒数第N个结点 {
    //思路：要找到 倒数第n个节点 通过双指针 指针差就是第n个点
    public ListNode removeNthFromEnd(ListNode head, int n) {
        //添加预先指针 防止第一个节点被删掉
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        //第一个指针 直接是head 那就少走一步
        ListNode first = head;
        ListNode second = dummy;
        for (int i = 0; i < n; ++i) {
            first = first.next;
        }
        while (first != null) {
            first = first.next;
            second = second.next;
        }
        second.next = second.next.next;
        ListNode ans = dummy.next;
        return ans;
    }
}
