package 动态规划;

/**
 * https://leetcode.cn/problems/minimum-path-sum/
 * medium
 * <p>
 * 给定一个包含非负整数的 m x n 网格 grid ，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。
 * <p>
 * 说明：每次只能向下或者向右移动一步。
 * <p>
 * 求最值 通过dp
 */
public class 最小路径和 {
    /**
     * /定义一个整型数组:3行4列
     * int a[][] = new int[3][4];
     * //获取行数---3行
     * int lenY = a.length;
     * //获取列数---4列
     * int lenX = a[0].length;
     */

    public int minPathSum(int[][] grid) {

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (i == 0 && j == 0) continue;// 处理【0，0】点位置
                else if (i == 0) {
                    grid[i][j] = grid[i][j - 1] + grid[i][j];//处理第一行的数据，依赖于前一列的值
                } else if (j == 0) {
                    grid[i][j] = grid[i - 1][j] + grid[i][j];//处理第一列的数据，依赖于前一行的数据
                } else {
                    grid[i][j] = Math.min(grid[i - 1][j], grid[i][j - 1]) + grid[i][j];
                }
            }
        }
        return grid[grid.length - 1][grid[0].length - 1];
    }
}
