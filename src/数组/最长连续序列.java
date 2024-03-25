package 数组;

import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode.cn/problems/longest-consecutive-sequence
 * medium
 * 给定一个未排序的整数数组 nums ，找出数字连续的最长序列（不要求序列元素在原数组中连续）的长度。
 * <p>
 * 请你设计并实现时间复杂度为O(n) 的算法解决此问题。
 * 由于排序的时间复杂度至少有 O(nlogn) 不能使用排序
 * 一般在leetcode中，对时间复杂度有要求，就用空间来换，对空间复杂度有要求，就用时间来换。
 */
public class 最长连续序列 {
    /**
     * 基于这种思路我们就想要求最长的，就是要记录下有没有相邻的元素，比如遍历到100这个元素，我们需要查看[99, 101]这两个元素在不在序列中，
     * 这样去更新最大长度。而记录元素有没有这个事我们太熟悉了，用set这种数据结构，而set这种数据结构是需要o(n)的空间来换取的，这就是我们刚才说的用空间来换时间。
     */
    public static int longestConsecutive(int[] nums) {
        //添加到set中 目的除去了重复的数
        HashSet<Integer> numsSet = new HashSet<>();
        for (int  num : nums) {
            numsSet.add(num);
        }
        int longest = 0;
        // 原答案这里还用的原数组 还是存在重复数组 多次遍历
        // 转成数组最好
        Integer[] nums2 = numsSet.toArray(new Integer[0]);
        for (int  num : nums2) {
            if (numsSet.remove(num)) {
                // 向当前元素的左边搜索,eg: 当前为100, 搜索：99，98，97,...
                int currentLongest = 1;
                int current = num;
                while (numsSet.remove(current - 1)) current--;
                currentLongest += (num - current);
                // 向当前元素的右边搜索,eg: 当前为100, 搜索：101，102，103,...
                current = num;
                while (numsSet.remove(current + 1)) current++;
                currentLongest += (current - num);
                // 搜索完后更新longest.
                longest = Math.max(longest, currentLongest);
            }
        }
        return longest;
    }

    /**
     * [100,4,200,1,3,2] 输出 4
     */

    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3,4,254,12,3,1};
        int value = longestConsecutive(nums);
        System.out.println(value);
    }

    public static int longestConsecutive2(int[] nums) {
        // 转化成哈希集合，方便快速查找是否存在某个元素
        HashSet<Integer> set = new HashSet<Integer>();
        for (int num : nums) {
            set.add(num);
        }

        int res = 0;

        for (int num : set) {
            if (set.contains(num - 1)) {
                // num 不是连续子序列的第一个，跳过
                continue;
            }
            // num 是连续子序列的第一个，开始向上计算连续子序列的长度
            int curNum = num;
            int curLen = 1;

            while (set.contains(curNum + 1)) {
                curNum += 1;
                curLen += 1;
            }
            // 更新最长连续序列的长度
            res = Math.max(res, curLen);
        }

        return res;
    }
}
