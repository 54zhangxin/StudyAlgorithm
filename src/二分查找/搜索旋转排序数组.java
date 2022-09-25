package 二分查找;

/**
 * https://leetcode.cn/problems/search-in-rotated-sorted-array/
 *
 * 出现次数还挺多
 * medium
 * 从已经旋转过都数组中找出目标值在旋转前数组中的位置并返回。
 */
public class 搜索旋转排序数组 {

    public  static  int search(int[] nums, int target) {
        int len = nums.length;
        if(len == 0) return -1;
        int left = 0, right = len - 1;
        // 1. 首先明白，旋转数组后，从中间划分，一定有一边是有序的。[4,5,6,7,0,1,2]
        // 2. 由于一定有一边是有序的，所以根据有序的两个边界值来判断目标值在有序一边还是无序一边
        // 3. 这题找目标值，遇到目标值即返回
        // 4. 注意：由于有序的一边的边界值可能等于目标值，所以判断目标值是否在有序的那边时应该加个等号
        // (在二分查找某个具体值得时候如果把握不好边界值，可以再每次查找前判断下边界值，也就是while循环里面的两个if注释)
        while(left <= right){
            // if(nums[left] == target) return left;
            // if(nums[right] == target) return right;
            //**二分细节**
            int mid = left + (right - left) / 2;//或者写 int mid = (left + right) / 2;

            if(nums[mid] == target) return mid;
            // 右边有序
            if(nums[mid] < nums[right]){
                // 目标值在右边
                if(target > nums[mid] && target <= nums[right]){
                    left = mid + 1;
                    // 目标值在左边
                }else{
                    right = mid - 1;
                }
                // 左边有序
            }else{
                // 目标值在左边
                if(target >= nums[left] && target < nums[mid]){
                    right = mid - 1;
                }else{
                    // 目标值在右边
                    left = mid + 1;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] num = new int[]{4,5,6,7,0,1,2};
        search(num,0);
    }

}