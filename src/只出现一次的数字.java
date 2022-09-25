/**
 * https://leetcode.cn/problems/single-number/
 * easy
 * 不使用额外空间就不能用set
 *
 * 异或（xor）是一个数学运算符。它应用于逻辑运算。异或的数学符号为“⊕”，计算机符号为“xor”。
 * 二进制下异或运算法则：
 * 1 xor 1=0
 * 0 xor 0=0
 * 1 xor 0=1
 * 0 xor 1=1
 * 因此十进制下相同数字异或结果为0，数字a与0异或结果仍为原来的数字a
 *
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
