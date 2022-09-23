import java.util.HashMap;

/**
 * 给定一个整数数组和一个整数 k，你需要找到该数组中和为 k 的连续的子数组的个数。
 * 示例 1 : 输入:nums = [1,1,1], k = 2 输出: 2 , [1,1] 与 [1,1] 为两种不同的情况。
 * 说明 : 数组的长度为 [1, 20,000]。 数组中元素的范围是 [-1000, 1000] ，且整数 k 的范围是 [-1e7, 1e7]。
 *
 * 解题思路
 * 假设一个数组nums的元素为[a1,a2,a3,a4]，假设我们使用f(a,b)代表从数组下标a到数组下标b的连续子数组和，f(a,b)=f(0,b)-f(0,a)，
 * 也就是说假设子数组的和[a2,a3]=[a1,a2,a3]-[a1]，所以k = [a1,a2,a3]-[a1]，我们判断和为k的数量，
 * 其实也就判断从0开始的子树组之间的差为k的数量，所以我们计算将从下标为0的数组的和，添加到HashMap中去，然后遍历时进行判断。
 */
public class 和为K的子数组 {
    public int subarraySum(int[] nums, int k) {
        if (nums==null||nums.length==0) { return 0; }
        int matchTimes=0;
        int sum=0;
        HashMap<Integer,Integer> sumMap = new HashMap<>();
        //这个主要是为了统计为从0到i的和为sum的子数组
        sumMap.put(0,1);
        for (int i = 0; i < nums.length; i++) {
            sum+=nums[i];
            int key =  sum - k;
            if (sumMap.containsKey(key)) {
                matchTimes+=sumMap.get(key);
            }
            //将当前sum和添加到map中去
            Integer times = sumMap.get(sum);
            if (times==null) {
                times=0;
            }
            sumMap.put(sum,times+1);
        }
        return matchTimes;
    }

}
