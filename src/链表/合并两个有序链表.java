package 链表;

/**
 * 题目详情：https://leetcode-cn.com/problems/merge-two-sorted-lists/
 * 将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
 * 必会
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

/* 递归理解：
   list1:  a(1) -> b(3) -> c(5)   list2: d(2）-> e(4) -> f(6)
   第一次判断: a节点值小于d的值
      a(1）。next = mergeTwoList(b,d);
      第二次判断： b的值大于d的值
        d（2）。next = mergeTwoList(b,e);
          第三次判断： b的值小于e 值
             b（3），next =  mergeTwoList(c,e);
               第四次判断 ： c的值大于e的值
                 e（4），next =  mergeTwoList(c,f);
                   第五次判断： c的值小于f的值
                       c，next =  mergeTwoList(null ,f);
                      此时 遇到了l1为空的判断 返回了 list2 的节点即：f 所以c.next = f 同理： c-》f
                 递归到头了开始回退
                 e.next = c    e -> c
              b.next = e   b -> e
        d.next = b  d->b
      a.next = d  a->d
  最终 a(1) -> d(2) -> b(3) -> e(4) -> c(5)  -> f(6)
 */
