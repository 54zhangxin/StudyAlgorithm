package 数组;

import java.util.Deque;
import java.util.LinkedList;

/**
 * https://leetcode.cn/problems/daily-temperatures/
 * medium
 * 题意： 给一数组然后求出新的一组数组
 *       新数组的值 是老数组中值比他大就行
 * 比如
 * 输入: temperatures = [73,74,75,71,69,72,76,73]
 * 输出: [1,1,4,2,1,1,0,0]
 * 单调栈
 * 遇到一个新元素，如果它比栈顶元素小，那就让它入栈，否则就弹出栈顶元素，直到这个新元素比栈顶元素小，再让它入栈。这样的话，
 * 最终的结果就是栈内的元素是从栈底到栈顶是递减的，其出栈的顺序就是递增的，这样的栈叫做单调递增栈。反过来就是单调递减栈
 */
public class 每日温度 {
    public int[] dailyTemperatures(int[] temperatures) {
        int length = temperatures.length;
        int[] ans = new int[length];
        // 栈内存储的是温度的下标
        Deque<Integer> stack = new LinkedList<Integer>();
        for (int i = 0; i < length; i++) {
            //该天的温度
            int temperature = temperatures[i];
            // 当站内不为空，并且该天的温度大于栈顶的温度。就弹出栈顶元素 然后给弹出的下标天数差算出来 放入ans
            while (!stack.isEmpty() && temperature > temperatures[stack.peek()]) {
                int prevIndex = stack.pop();
                ans[prevIndex] = i - prevIndex;
            }
            stack.push(i);
        }
        return ans;
    }
}
