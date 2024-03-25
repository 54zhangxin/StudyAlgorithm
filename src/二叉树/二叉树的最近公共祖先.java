package 二叉树;

/**
 * https://leetcode.cn/problems/lowest-common-ancestor-of-a-binary-tree/
 * medium
 * 给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。
 * 最近公共祖先的定义为：“对于有根树 T 的两个节点 p、q，最近公共祖先表示为一个节点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”
 * 链接：https://leetcode.cn/problems/lowest-common-ancestor-of-a-binary-tree/solution/236-er-cha-shu-de-zui-jin-gong-gong-zu-xian-hou-xu/
 * 题解的图很棒
 */
public class 二叉树的最近公共祖先 {

    /**
     *
     *                3
     *           5         1
     *        6     2    0    8
     *            7   4
     * root = 3 ,p = 7, q = 3
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        //根据题意 2个指定的节点是在该树中，如果等于root那就返回
        if (root == null || root == p || root == q) {
            return root;
        }

        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if (left == null) return right;
        if (right == null) return left;
        return root;
    }

}
