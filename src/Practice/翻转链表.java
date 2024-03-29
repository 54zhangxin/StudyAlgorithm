package Practice;

import 链表.ListNode;

public class 翻转链表 {

    public ListNode reverseList(ListNode head){

        if (head==null||head.next==null){
            return  head;
        }

        ListNode pre = null;
        ListNode cur = head;
        while (cur != null){
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }

        return pre;
    }
}
