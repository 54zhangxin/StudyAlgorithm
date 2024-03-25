package 二叉树;

/**
 * https://leetcode.cn/problems/binary-tree-maximum-path-sum/
 * hard
 * 二叉树中的 路径 被定义为一条节点序列，序列中每对相邻节点之间都存在一条边。同一个节点在一条路径序列中 至多出现一次 。该路径 至少包含一个 节点，且不一定经过根节点。
 * 路径和 是路径中各节点值的总和。
 * 给你一个二叉树的根节点 root ，返回其 最大路径和 。
 */
public class 二叉树中的最大路径和 {
    /**
     * 思考 这题是 二叉树的直径 变种
     * 需要找到最大的路径 还要把他们的值加起来 是负数还要特殊处理
     * https://leetcode.cn/problems/binary-tree-maximum-path-sum/solution/shou-hui-tu-jie-hen-you-ya-de-yi-dao-dfsti-by-hyj8/
     */

    int maxSum = Integer.MIN_VALUE; // 最大路径和

    public int maxPathSum(TreeNode root) {
        dfs(root);
        return maxSum;
    }

    /**
     * 递归函数，计算以当前节点为根节点的子树的最大路径和
     * @param root 当前节点
     * @return 以当前节点为根节点的子树对外提供的最大路径和
     */
    private int dfs(TreeNode root) {
        if (root == null) {
            return 0; // 遍历到null节点，收益0
        }

        int left = dfs(root.left); // 左子树提供的最大路径和
        int right = dfs(root.right); // 右子树提供的最大路径和

        int innerMaxSum = left + root.val + right; // 当前子树内部的最大路径和
        maxSum = Math.max(maxSum, innerMaxSum); // 挑战最大纪录

        int outputMaxSum = root.val + Math.max(0, Math.max(left, right)); // 当前子树对外提供的最大和

        // 如果对外提供的路径和为负，直接返回0。否则正常返回
        return Math.max(outputMaxSum, 0);
    }
}
