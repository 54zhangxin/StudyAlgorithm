package 动态规划;

/**
 * https://leetcode.cn/problems/maximum-subarray/
 * medium   求最值 基本上用动态规划解
 * 又名：最大子序和
 * 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 */
public class 最大子数组和 {
    // 详细解析参见：
// https://labuladong.github.io/article/?qno=53
    public int maxSubArray(int[] nums) {
        int n = nums.length;
        if (n == 0) return 0;
        int[] dp = new int[n];
        // base case
        // 第一个元素前面没有子数组
        dp[0] = nums[0];
        // 状态转移方程
        for (int i = 1; i < n; i++) {
            dp[i] = Math.max(nums[i], nums[i] + dp[i - 1]);
        }
        // 得到 nums 的最大子数组
        int res = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            res = Math.max(res, dp[i]);
        }
        return res;
    }


    // 这个动态规划 讲得好
    // https://leetcode.cn/problems/maximum-subarray/solution/dong-tai-gui-hua-fen-zhi-fa-python-dai-ma-java-dai/

    //https://leetcode.cn/problems/maximum-subarray/solution/hua-jie-suan-fa-53-zui-da-zi-xu-he-by-guanpengchn/
    // 看图就懂了。。
    public int maxSubArray2(int[] nums) {
        int ans = nums[0];
        int sum = 0;
        for (int num : nums) {
            if (sum > 0) {
                sum += num;
            } else {
                sum = num;
            }
            ans = Math.max(ans, sum);
        }
        return ans;
    }


}
