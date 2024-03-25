package 数组;

/**
 * https://leetcode.cn/problems/rotate-image/
 * medium
 * 给定一个 n × n 的二维矩阵 matrix 表示一个图像。请你将图像顺时针旋转 90 度。
 * 1 2 3     7 4 1
 * 4 5 6  => 8 5 2
 * 7 8 9     9 6 3
 * 输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
 * 输出：[[7,4,1],[8,5,2],[9,6,3]]
 *.
 * 这道题务必要掌握空间复杂度O(1)的算法
 */
public class 旋转图像 {
    public void rotate(int[][] matrix) {
        //看这个解释  先沿对角线 交换 然后在翻转 每一行
        //https://labuladong.github.io/algo/di-yi-zhan-da78c/shou-ba-sh-48c1d/er-wei-shu-150fb/
        int n = matrix.length;
        // 先沿对角线镜像对称二维矩阵
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                // swap(matrix[i][j], matrix[j][i]);
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        // 然后反转二维矩阵的每一行
        for (int[] row : matrix) {
            reverse(row);
        }
    }

    // 反转一维数组
    void reverse(int[] arr) {
        int i = 0, j = arr.length - 1;
        while (j > i) {
            // swap(arr[i], arr[j]);
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            i++;
            j--;
        }
    }
}
