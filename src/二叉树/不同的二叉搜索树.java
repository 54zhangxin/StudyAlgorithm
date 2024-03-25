package 二叉树;

/**
 * <a href="https://leetcode.cn/problems/unique-binary-search-trees/">...</a>
 * 题目 中等 出现频次10  hot100
 * 给你一个整数 n ，求恰由 n 个节点组成且节点值从 1 到 n 互不相同的 二叉搜索树 有多少种？返回满足题意的二叉搜索树的种数。
 * <p>
 * 这题不就是找规律吗，数学的应用 。。
 */
public class 不同的二叉搜索树 {
    //动态规划解法
    // https://leetcode.cn/problems/unique-binary-search-trees/solutions/6693/hua-jie-suan-fa-96-bu-tong-de-er-cha-sou-suo-shu-b
    public int numTrees(int n) {
        int[] G = new int[n + 1];
        G[0] = 1;
        G[1] = 1;
        for (int i = 2; i <= n; ++i) {
            for (int j = 1; j <= i; ++j) {
                G[i] += G[j - 1] * G[i - j];
            }
        }
        return G[n];
    }


    //https://leetcode.cn/problems/unique-binary-search-trees/solutions/1319816/a-qiu-javadi-gui-jie-fa-by-emeraki-qi2d/
    // 这个更好理解 上面的dp偏向数学公式的运用
}
