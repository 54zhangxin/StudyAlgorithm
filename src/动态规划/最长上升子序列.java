package 动态规划;

import java.util.Arrays;

/**
 * <a href="https://leetcode.cn/problems/longest-increasing-subsequence/">...</a>
 * medium
 * 给你一个整数数组 nums ，找到其中最长严格递增子序列的长度。
 * <p>
 * 子序列是由数组派生而来的序列，删除（或不删除）数组中的元素而不改变其余元素的顺序。例如，[3,6,2,7] 是数组 [0,3,1,6,2,2,7] 的子序列。
 */
public class 最长上升子序列 {
    /**
     * https://leetcode.cn/problems/longest-increasing-subsequence/solution/zui-chang-shang-sheng-zi-xu-lie-dong-tai-gui-hua-2/
     *
     * 如果想要输出 最长上升子序列数组 需要看解法二
     */
    public int lengthOfLIS(int[] nums) {
        int len = nums.length;
        if (len < 2) {
            return len;
        }

        int[] dp = new int[len];
        //填满数组。。。
        Arrays.fill(dp, 1);
        // 以数组的第2个元素开始 以nums[i]结尾 最长上升子序列 来计算。
        for (int i = 1; i < len; i++) {
            //从数组的第一个元素开始
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }

        int res = 0;
        // 从状态dp 数组中找出最大值 就是题目的解
        for (int i = 0; i < len; i++) {
            res = Math.max(res, dp[i]);
        }
        return res;
    }


}
