package 数组;

/**
 * leetcode:  https://leetcode.cn/problems/trapping-rain-water/solution/jie-yu-shui-by-leetcode/327718/
 *
 * https://labuladong.gitee.io/algo/4/33/129/
 */
public class 接雨水 {

    // 动态规划
    //时间复杂度降低为 O(N)
    static int trap(int[] height) {
        if (height.length == 0) {
            return 0;

        }
        int n = height.length;
        int res = 0;
        //数组充当备忘录
        int[] l_max = new int[n];
        int[] r_max = new int[n];
        //初始化 base case
        l_max[0] = height[0];
        r_max[n - 1] = height[n - 1];
        //从左向右计算 l_max
        for (int i = 1; i < n; i++) {
            l_max[i] = Math.max(height[i], l_max[i - 1]);
        }
        //从右向左计算r_max
        for (int i = n - 2; i >= 0; i--) {
            r_max[i] = Math.max(height[i], r_max[i + 1]);
        }
        // 计算答案
        for (int i = 1; i < n - 1; i++)
            res += Math.min(l_max[i], r_max[i]) - height[i];

//        System.out.println(Arrays.toString(l_max));
//        System.out.println(Arrays.toString(r_max));

        return res;
    }

    /**
     * 双指针解法(最优解)

     * 定理一：在某个位置i处，它能存的水，取决于它左右两边的最大值中较小的一个。

     * 定理二：当我们从左往右处理到left下标时，左边的最大值left_max对它而言是可信的，但right_max对它而言是不可信的。
     * （见下图，由于中间状况未知，对于left下标而言，right_max未必就是它右边最大的值）

     * 定理三：当我们从右往左处理到right下标时，右边的最大值right_max对它而言是可信的，但left_max对它而言是不可信的。
     *                                    right_max
     *  left_max                             __
     *    __                                |  |
     *   |  |__   __??????????????????????  |  |
     * __|     |__|                       __|  |__
     *         left                      right

     * 对于位置left而言，它左边最大值一定是left_max，右边最大值“大于等于”right_max，这时候，如果left_max<right_max成立，
     * 那么它就知道自己能存多少水了。无论右边将来会不会出现更大的right_max，都不影响这个结果。 所以当left_max<right_max时，
     * 我们就希望去处理left下标，反之，我们希望去处理right下标。
     */
    static int trap2(int[] height) {
        /**
         * left_max：左边的最大值，它是从左往右遍历找到的
         * right_max：右边的最大值，它是从右往左遍历找到的
         * left：从左往右处理的当前下标
         * right：从右往左处理的当前下标
         */

        int res = 0;//最大接水量
        int left_max = 0;
        int right_max = 0;
        int left = 0, right = height.length - 1;
        while (left < right) {
            left_max = Math.max(left_max, height[left]);
            right_max = Math.max(right_max, height[right]);
            if (left_max < right_max) {
                res += left_max - height[left];
                left++;
            } else {
                res += right_max - height[right];
                right--;
            }
        }
        return res;
    }


    public static void main(String[] args) {

        int[] height = new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        int trap = trap2(height);
        System.out.println(trap);

    }
}
