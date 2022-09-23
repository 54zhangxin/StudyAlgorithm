/**
 * https://leetcode.cn/problems/single-number/
 * easy
 */
public class 只出现一次的数字 {
    public int singleNumber(int[] nums) {
        int value = 0;
        for (int i = 0; i < nums.length; i++) {
            value = value ^ nums[i];
        }
        return value;
    }
}
