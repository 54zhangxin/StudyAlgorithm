package 二叉树;

/**
 * https://leetcode.cn/problems/diameter-of-binary-tree/
 * easy
 * 给定一棵二叉树，你需要计算它的直径长度。一棵二叉树的直径长度是任意两个结点路径长度中的最大值。这条路径可能穿过也可能不穿过根结点。
 * 注意：两结点之间的路径长度是以它们之间边的数目表示。
 *。
 * 最大的直径可能有三种情况：
 * 1.在左子树内部
 * 2.在右子树内部
 * 3.在穿过左子树，根节点，右子树的一条路径中
 */
public class 二叉树的直径 {
    int max = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        depth(root);
        return max;
    }

    private int depth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        //计算左子树最大深度，不包含当前节点
        int left = depth(root.left);
        // 计算右子树最大深度，不包含当前节点
        int right = depth(root.right);
        //将每个节点最大直径(左子树深度+右子树深度)当前最大值比较并取大者
        max = Math.max(left + right, max);
        // 返回当前节点的最大深度(包含了当前节点)
        // +1目的是要包含根节点，L或R只是其左右子树的深度
        return Math.max(left, right) + 1;//返回节点深度
    }

}
