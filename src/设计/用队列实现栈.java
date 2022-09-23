package 设计;

import java.util.LinkedList;
import java.util.Queue;

/**
 * https://leetcode.cn/problems/implement-stack-using-queues/
 * 使用两个队列实现一个后入先出（LIFO）的栈，并支持普通栈的全部四种操作（push、top、pop 和 empty）。
 * <p>
 * 实现 MyStack 类：
 * <p>
 * void push(int x) 将元素 x 压入栈顶。
 * int pop() 移除并返回栈顶元素。
 * int top() 返回栈顶元素。
 * boolean empty() 如果栈是空的，返回 true ；否则，返回 false 。
 */
public class 用队列实现栈 {
    /**
     * 思路 相互交换
     */
    Queue<Integer> queue1, queue2;

    public 用队列实现栈() {
        queue1 = new LinkedList<>();
        queue2 = new LinkedList<>();
    }

    public void push(int x) {

        queue2.offer(x);

        while (!queue1.isEmpty()) {
            queue2.offer(queue1.poll());
        }

        Queue<Integer> temp = queue1;
        queue1 = queue2;
        queue2 = temp;
    }

    public int pop() {
        return queue1.poll();//	删除并返回第一个元素。
    }

    public int top() {
        return queue1.peek();//返回第一个元素。
    }

    public boolean empty() {
        return queue1.isEmpty();
    }
}
