package 二叉树;

/**
 * https://leetcode.cn/problems/diameter-of-binary-tree/
 * easy
 * 给定一棵二叉树，你需要计算它的直径长度。一棵二叉树的直径长度是任意两个结点路径长度中的最大值。这条路径可能穿过也可能不穿过根结点。
 * 注意：两结点之间的路径长度是以它们之间边的数目表示。
 */
public class 二叉树的直径 {
    int maxd = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        depth(root);
        return maxd;
    }

    private int depth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int left = depth(root.left);
        int right = depth(root.right);
        maxd = Math.max(left + right, maxd);//将每个节点最大直径(左子树深度+右子树深度)当前最大值比较并取大者
        return Math.max(left, right) + 1;//返回节点深度
    }

}
