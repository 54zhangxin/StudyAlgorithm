package 数组;

/**
 * https://leetcode.cn/problems/search-a-2d-matrix-ii/
 * medium

 * 给你一个满足下述两条属性的 m x n 整数矩阵：
 *   1.每行中的整数从左到右按非递减顺序排列。
 *   2.每行的第一个整数大于前一行的最后一个整数。
 * 给你一个整数 target ，如果 target 在矩阵中，返回 true ；否则，返回 false 。
 * 1    3   5    7
 * 10   11  16   20
 * 23   30  34   60
 * 输入：matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 3
 * 输出：true

 * 题意 从一个从左到右 从上到下依次递增的二维数组中 找出目标值
 * 解法1：二分查找
 * 解法2：右上角依次遍历
 */
public class 搜索二维矩阵 {
    //二分查找
    public boolean searchMatrix(int[][] matrix, int target) {
        for (int[] row : matrix) {
            int index = search(row, target);
            if (index >= 0) {
                return true;
            }
        }
        return false;
    }

    public int search(int[] nums, int target) {
        int low = 0, high = nums.length - 1;
        while (low <= high) {
            int mid = (high - low) / 2 + low;
            int num = nums[mid];
            if (num == target) {
                return mid;
            } else if (num > target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }

    //从右上角开始遍历

    public boolean searchMatrix2(int[][] matrix, int target) {

        if (matrix.length == 0 && matrix[0].length == 0) return false;
        int i = 0, j = matrix[0].length - 1;  //矩阵右上角
        while (i < matrix.length && j >= 0) {
            if (matrix[i][j] == target) return true;
            else if (matrix[i][j] < target) i++;  //排除一行
            else if (matrix[i][j] > target) j--;  //排除一列
        }
        return false;

//        作者：lin-shen-shi-jian-lu-k
//        链接：https://leetcode.cn/problems/search-a-2d-matrix-ii/solution/sou-suo-er-wei-ju-zhen-ii-cong-you-shang-e0vj/
//        来源：力扣（LeetCode）
//        著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
    }

}
