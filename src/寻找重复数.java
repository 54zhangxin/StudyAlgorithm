/**
 * https://leetcode.cn/problems/find-the-duplicate-number/
 * medium
 * <p>
 * 找出重复的数字并输出 题目假设了只有一个重复数字
 * 必须 不修改 数组 nums 且只用常量级 O(1) 的额外空间。
 */
public class 寻找重复数 {
    //https://leetcode.cn/problems/find-the-duplicate-number/solution/287xun-zhao-zhong-fu-shu-by-kirsche/
    // 根据 数组下标 对于的值 然后值变成数组下标，如果成环
    // 跟环形链表2 相同的思路
    public int findDuplicate(int[] nums) {

        int fast = 0;
        int slow = 0;
        fast = nums[nums[fast]];
        slow = nums[slow];
        while (fast != slow) {
            fast = nums[nums[fast]];
            slow = nums[slow];
        }
        fast = 0;
        while (fast!=slow){
            fast = nums[fast];
            slow = nums[slow];
        }
        return slow;
    }
}
