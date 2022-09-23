package 动态规划;

/**
 * https://leetcode.cn/problems/house-robber/
 * medium
 */
public class 打家劫舍 {

    //dp标准

    /**
     * dp表示走到这间房间的最大总金额，等于前一间房间的最大总金额和前前一件房间的最大总金额加上该间房间的最大金额区最大值
     * 即： dp[i] =MatH.max( dp[i-2]+nums[i],dp[i-1])
     */
    public int rob2(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int length = nums.length;
        if (length == 1) {
            return nums[0];
        }
        int[] dp = new int[length];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        for (int i = 2; i < length; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
        }
        return dp[length - 1];
    }

    /**
     * 优化后的
     *
     * @param nums
     * @return
     */
    public int rob(int[] nums) {

        //pre 记录前一位的最大总金额
        // cur 表示当前金额，tmp 记录当前位置前一位都最大金额
        int pre = 0, cur = 0, tmp;
        for (int num : nums) {
            tmp = cur;
            cur = Math.max(pre + num, cur);
            pre = tmp;
        }
        return cur;
    }
}
