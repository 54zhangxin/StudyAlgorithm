package 数组;

/**
 * https://leetcode.cn/problems/move-zeroes/solution/dong-hua-yan-shi-283yi-dong-ling-by-wang_ni_ma/
 * easy
 * .
 * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 * 请注意 ，必须在不复制数组的情况下原地对数组进行操作。
 * ,
 * 例如 输入: nums = [0,1,0,3,12]
 *     输出: [1,3,12,0,0]
 * 双指针
 * 数组
 */
public class 移动零 {
    public void moveZeroes(int[] nums) {
        if (nums == null) {
            return;
        }
        //第一次遍历的时候，j指针记录非0的个数，只要是非0的统统都赋给nums[j]
        int j = 0;
        for (int i = 0; i < nums.length; ++i) {
            if (nums[i] != 0) {
                nums[j++] = nums[i];
            }
        }
        //非0元素统计完了，剩下的都是0了
        //所以第二次遍历把末尾的元素都赋为0即可
        for (int i = j; i < nums.length; ++i) {
            nums[i] = 0;
        }
    }

    /**
     * 可以学一下 https://labuladong.github.io/algo/di-yi-zhan-da78c/shou-ba-sh-48c1d/shuang-zhi-fa4bd/#%E4%B8%80%E3%80%81%E5%BF%AB%E6%85%A2%E6%8C%87%E9%92%88%E6%8A%80%E5%B7%A7
     * 思路同:第 83 题「删除排序链表中的重复元素」https://leetcode.cn/problems/remove-duplicates-from-sorted-list/
     */

}
