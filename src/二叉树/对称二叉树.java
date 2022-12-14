package 二叉树;

/**
 * https://leetcode.cn/problems/dui-cheng-de-er-cha-shu-lcof/
 * easy
 */
public class 对称二叉树 {
    public boolean isSymmetric(TreeNode root) {

        return root == null ? true : recur(root.left, root.right);
    }

    boolean recur(TreeNode L, TreeNode R) {
        if (L == null && R == null) return true;
        if (L == null || R == null || L.val != R.val) return false;
        return recur(L.left, R.right) && recur(L.right, R.left);
    }

}
