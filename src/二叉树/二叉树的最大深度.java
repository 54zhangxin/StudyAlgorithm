package 二叉树;

/**
 * https://leetcode.cn/problems/maximum-depth-of-binary-tree/
 * easy
 * 给定一个二叉树，找出其最大深度。
 * 二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。
 * 说明: 叶子节点是指没有子节点的节点。
 * 示例：
 * 给定二叉树 [3,9,20,null,null,15,7]
 * .
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回它的最大深度 3
 * 解法： 深度优先遍历 DFS
 */
public class 二叉树的最大深度 {

    //https://leetcode.cn/problems/maximum-depth-of-binary-tree/solution/acm-xuan-shou-tu-jie-leetcode-er-cha-shu-ckf4/
    public int maxDepth(TreeNode root) {
        // 节点为空，高度为 0
        if (root == null) {
            return 0;
        }
        // 递归计算左子树的最大深度
        int left = maxDepth(root.left);
        // 递归计算右子树的最大深度
        int right = maxDepth(root.right);
        // 二叉树的最大深度 = 子树的最大深度 + 1 （1 是根节点）
        return Math.max(left, right) + 1;

    }
}
