package 数组;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode.cn/problems/3sum/
 * <p>
 * 中等
 * 必会
 * 给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有和为 0 且不重复的三元组。
 * 注意：答案中不可以包含重复的三元组。
 */
public class 三数之和 {

    /**
     * https://leetcode.cn/problems/3sum/solution/hua-jie-suan-fa-15-san-shu-zhi-he-by-guanpengchn/
     * 思路：
     * 标签：数组遍历
     * 1.首先对数组进行排序，排序后固定一个数nums[i],在使用左右指针指向nums[i]后面的两端
     * 数组分别为nums[L]和nums[R]，计算三个数的和sum判断是否满足为0，满足则填进结果集
     * 2.如果nums[i] 大于0，则三数之和必然无法等于0，结束循环
     * 3.如果nums[i] ==nums[i-1],则说明该数字重复，会导致结果重复，所以应该跳过
     * 4.当sum==0时，nums[L]==nums[L+1]则会导致结果重复，应该填过，L++
     * 5.当sum==0时，nums[R]==nums[R-1]则会导致结果重复，应该填过，R--
     * .
     * 时间复杂度O（n的平方），n为数组长度
     */
    //排序, 双指针, 两次去重
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        if (nums == null) {
            return ans;
        }

        int len = nums.length;
        if (len < 3) {
            return ans;
        }

        Arrays.sort(nums);

        for (int i = 0; i < len; i++) {
            //如果当前数字大于0，则三数之和一定大于0，结束循环
            if (nums[i] > 0) break;

            if (i > 0 && nums[i] == nums[i - 1]) continue;//去重

            int L = i + 1;
            int R = len - 1;
            while (L < R) {

                int sum = nums[i] + nums[L] + nums[R];

                if (sum == 0) {
                    ans.add(Arrays.asList(nums[i], nums[L], nums[R]));
                    while (L < R && nums[L] == nums[L + 1]) L++; // 去重
                    while (L < R && nums[R] == nums[R - 1]) R--; // 去重
                    L++;
                    R--;
                } else if (sum < 0) {
                    L++;
                } else {
                    R--;
                }
            }
        }

        return ans;
    }
}
