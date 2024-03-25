package 字符串;

/**
 * 72.https://leetcode.cn/problems/edit-distance/description/
 * hard
 * 给你两个单词 word1 和 word2，请你计算出将 word1 转换成 word2 所使用的最少操作数 。
 * 你可以对一个单词进行如下三种操作：
 * 插入一个字符
 * 删除一个字符
 * 替换一个字符
 * https://leetcode-cn.com/problems/edit-distance/solution/zi-di-xiang-shang-he-zi-ding-xiang-xia-by-powcai-3/
 * Levenshtein Distance动态规划方法#
 * 可以使用动态规划的方法去测量LD的值，步骤大致如下：
 *.二维表填表，视频很清楚 https://www.bilibili.com/video/BV15h411Z7Qd/?spm_id_from=333.337.search-card.all.click&vd_source=2175a27700f015df8ce8217e4cd89879
 * 初始化一个LD矩阵(M,N)，M和N分别是两个输入字符串的长度。
 * 矩阵可以从左上角到右下角进行填充，每个水平或垂直跳转分别对应于一个插入或一个删除。
 * 通过定义每个操作的成本为1，如果两个字符串不匹配，则对角跳转的代价为1，否则为0，简单来说就是：
 * 如果[i][j]位置的两个字符串相等，则从[i][j]位置左加1，上加1，左上加0，然后从这三个数中取出最小的值填充到[i][j]。
 * 如果[i][j]位置的两个字符串不相等，则从[i][j]位置左、左上、上三个位置的值中取最小值，这个最小值加1（或者说这三个值都加1然后取最小值），然后填充到[i][j]。
 * 按照上面规则LD矩阵(M,N)填充完毕后，最终矩阵右下角的数字就是两个字符串的LD值。
 */

public class 编辑距离 {

    public int minDistance(String word1, String word2) {
        int m = word1.length(), n = word2.length();
        int[][] dp = new int[m + 1][n + 1];
        //赋边界值
        for (int i = 1; i <= m; i++) {
            dp[i][0] = i;
        }
        for (int i = 1; i <= n; i++) {
            dp[0][i] = i;
        }

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.min(dp[i - 1][j - 1],
                            Math.min(dp[i][j - 1], dp[i - 1][j])) + 1;
                }
            }
        }
        return dp[m][n];
    }

}
