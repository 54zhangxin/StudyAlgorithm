package 动态规划;

/**
 * https://leetcode.cn/problems/best-time-to-buy-and-sell-stock/solution/by-jyd-cu90/
 * 贪心 easy
 * 题目：
 * 给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
 * 如果你最多只允许完成一笔交易（即买入和卖出一支股票一次），设计一个算法来计算你所能获取的最大利润。
 *
 * 输入：[7,1,5,3,6,4]
 * 输出：5
 * 解释：在第 2 天（股票价格 = 1）的时候买入，在第 5 天（股票价格 = 6）的时候卖出，最大利润 = 6-1 = 5 。
 *      注意利润不能是 7-1 = 6, 因为卖出价格需要大于买入价格；同时，你不能在买入前卖出股票。
 */
public class 买卖股票的最佳时机 {

    public int maxProfit(int[] prices) {
        // cost 花费的成本
        int cost = Integer.MAX_VALUE;
        // profit 最高利润
        int profit = 0;
        for (int price : prices) {
            // 把花费最小值存储
            cost = Math.min(cost, price);
            // 更新利润 获取最大值
            profit = Math.max(profit, price - cost);
        }
        return profit;
    }

    // 这个读的有点累。。   https://leetcode.cn/circle/article/qiAgHn/

    //这个多看几遍就懂了
    //https://labuladong.github.io/algo/di-er-zhan-a01c6/yong-dong--63ceb/yi-ge-fang-3b01b/
}
