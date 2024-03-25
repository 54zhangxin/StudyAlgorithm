package 动态规划;

/**
 * https://leetcode.cn/problems/jump-game/
 * 给定一个非负整数数组 nums ，你最初位于数组的 第一个下标 。
 * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
 * 判断你是否能够到达最后一个下标。
 *
 */
public class 跳跃游戏 {

    /**
     * https://leetcode.cn/problems/jump-game/solution/55-by-ikaruga/830644

     * 核心思想其实是动态规划，dp[i]记录nums[i]之前所能到达的最远距离，dp[i] = max(dp[i-1], i + nums[i])，空间优化可以将dp[i]变为dp，dp就是题解中的k
     */

    public static boolean canJump(int[] nums) {
        if (nums == null) {
            return false;
        }
        //前n-1个元素能够跳到的最远距离
        int k = 0;

        for (int i = 0; i <= k; i++) {
            //第i个元素能够跳到的最远距离
            int temp = i + nums[i];
            //更新最远距离
            k = Math.max(k, temp);
            //如果最远距离已经大于或等于最后一个元素的下标,则说明能跳过去,退出. 减少循环
            if (k >= nums.length - 1) {
                return true;
            }
        }
        //最远距离k不再改变,且没有到末尾元素
        return false;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{3, 2, 1, 0, 4};

        System.out.println( canJump(nums));
    }
}
