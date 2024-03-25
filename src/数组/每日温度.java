package 数组;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

/**
 * https://leetcode.cn/problems/daily-temperatures/
 * medium 典型单调栈的题
 * 给定一个整数数组temperatures，表示每天的温度，返回一个数组answer，其中answer[i]是指对于第 i 天，下一个更高温度出现在几天后。
 * 如果气温在这之后都不会升高，请在该位置用0 来代替。

 * 题意： 给一数组然后求出新的一组数组
 *       新数组的值 是老数组中值比他大就行
 * 比如
 * 输入: temperatures = [73,74,75,71,69,72,76,73]
 * 输出:                [ 1, 1, 4, 2, 1, 1, 0, 0]

 * 单调栈
 * 遇到一个新元素，如果它比栈顶元素小，那就让它入栈，否则就弹出栈顶元素，直到这个新元素比栈顶元素小，再让它入栈。这样的话，
 * 最终的结果就是栈内的元素是从栈底到栈顶是递减的，其出栈的顺序就是递增的，这样的栈叫做单调递增栈。反过来就是单调递减栈
 */
public class 每日温度 {
    //时间复杂度： O(n)
    //空间复杂度： O(n)

    public int[] dailyTemperatures(int[] temperatures) {
        int length = temperatures.length;
        int[] ans = new int[length];
        // 栈内存储的是温度的下标
        Deque<Integer> stack = new LinkedList<>();
        for (int i = 0; i < length; i++) {
            //该天的温度
            int temperature = temperatures[i];
            // 当栈内不为空，并且该天的温度大于栈顶的温度。就弹出栈顶元素 然后给弹出的下标天数差算出来 放入ans
            while (!stack.isEmpty() && temperature > temperatures[stack.peek()]) {
                int prevIndex = stack.pop();
                ans[prevIndex] = i - prevIndex;
            }
            stack.push(i);
        }
        return ans;
    }
}
/**
 * 代码理解
 * 最好画图看 由于栈是存的温度坐标
 *  获取第 i 天的温度 栈不为空 并且温度大于
 */

/**
 * Deque : 双向队列：支持插入删除元素的线性集合。
 * java官方文档推荐用deque实现栈（stack）。

 * Deque是double ended queue，将其理解成双端结束的队列，双端队列，可以在首尾插入或删除元素。
 * Queue的解释中，Queue就是简单的FIFO队列。
 * 所以在概念上来说，Queue是FIFO的单端队列，Deque是双端队列。
 * 方法：
 * peek(): 返回队列头部的元素，如果队列为空，则会返回null
 * pop():  弹出栈中元素，也就是返回并移除队头元素，等价于removeFirst()，如果队列无元素，则发生NoSuchElementException
 * push(): 向栈中压入元素，也就是向队头增加元素，等价于addFirst()，如果元素为null，则发生NPE，如果栈空间受到限制，则发生IllegalStateException
 */