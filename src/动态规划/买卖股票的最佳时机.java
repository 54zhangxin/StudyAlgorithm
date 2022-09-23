package 动态规划;

/**
 * https://leetcode.cn/problems/best-time-to-buy-and-sell-stock/solution/by-jyd-cu90/
 * 贪心 easy
 * 题目：
 * 给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
 * 如果你最多只允许完成一笔交易（即买入和卖出一支股票一次），设计一个算法来计算你所能获取的最大利润。
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
}
