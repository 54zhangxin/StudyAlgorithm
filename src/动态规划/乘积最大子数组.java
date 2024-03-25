package 动态规划;

/**
 * https://leetcode.cn/problems/maximum-product-subarray/
 * medium
 * 求最大值  可考虑动态规划
 * 给你一个整数数组 nums ，请你找出数组中乘积最大的非空连续子数组（该子数组中至少包含一个数字），并返回该子数组所对应的乘积。
 * 输入: nums = [2,3,-2,4]
 * 输出: 6
 * 解释: 子数组 [2,3] 有最大乘积 6。
 */
public class 乘积最大子数组 {
    //https://leetcode.cn/problems/maximum-product-subarray/solution/hua-jie-suan-fa-152-cheng-ji-zui-da-zi-xu-lie-by-g/
    public int maxProduct(int[] nums) {
        int max = Integer.MIN_VALUE;//结果最大值
        int imax = 1; //阶段最大值
        int imin = 1; //阶段最小值
        for (int tmp : nums) {
            //当遇到负数的时候进行交换，因为阶段最小*负数就变阶段最大了，反之同理
            if (tmp < 0) {
                int exc = imax;
                imax = imin;
                imin = exc;
            }
            //在这里用乘积和元素本身比较的意思是：
            //对于最小值来说，最小值是本身则说明这个元素值比前面连续子数组的最小值还小。相当于重置了阶段最小值的起始位置
            imax = Math.max(imax * tmp, tmp);
            imin = Math.min(imin * tmp, tmp);
            //对比阶段最大值和结果最大值
            max = Math.max(imax, max);
        }
        return max;
    }
}
