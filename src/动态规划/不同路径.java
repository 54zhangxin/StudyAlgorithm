package 动态规划;
import java.util.Arrays;

/**
 * https://leetcode.cn/problems/unique-paths/
 * medium
 * 一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为 “Start” ）。
 * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为 “Finish” ）。
 * 问总共有多少条不同的路径？
 */
public class 不同路径 {
    /**
     *  a   n  c
     *  j   d  e
     *  w   k  w
     * 定义dp 数组 dp[i][j]  表示到达该点的路径和  可以由dp[i-1][j]加上dp[i][j-1]求得
     * dp[2][2] 只能由上边和左边的走过来
     * 因为只能通过向下和向右两种走法。
     */

    public int solution(int m, int n) {
        //动态规划解决
        //建立DP数组
        int[][] dp = new int[m][n];
        //初始化DP数组---》相当于获取动态规划当中的最优子结构
        for (int i = 0; i < m; i++) {
            dp[i][0] = 1;
        }
        for (int j = 0; j < n; j++) {
            dp[0][j] = 1;
        }
        //由题可知状态转移方程
        // dp[x][y]=dp[x-1][y]+dp[x][y-1];
        for (int x = 1; x < m; x++) {
            for (int y = 1; y < n; y++) {
                dp[x][y] = dp[x - 1][y] + dp[x][y - 1];
            }
        }
        return dp[m - 1][n - 1];
    }


    // 这解法2 空间优化，比较绕一点
    public static int uniquePaths(int m, int n) {
        //一维空间，其大小为 n
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        for(int i = 1; i < m; ++i) {
            for(int j = 1; j < n; ++j) {
                //等式右边的 dp[j]是上一次计算后的，加上左边的dp[j-1]即为当前结果
                dp[j] = dp[j] + dp[j - 1];
                int x= 0;
            }
        }
        return dp[n - 1];
    }

    public static void main(String[] args) {
        uniquePaths(3,3);

    }

}
