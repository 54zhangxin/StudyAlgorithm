package 二叉树;

/**
 * https://leetcode.cn/problems/flatten-binary-tree-to-linked-list/
 * medium
 * 展开后的单链表应该与二叉树 先序遍历 顺序相同。
 */
public class 二叉树展开为链表 {
    /**
     * https://leetcode.cn/problems/flatten-binary-tree-to-linked-list/solution/xiang-xi-tong-su-de-si-lu-fen-xi-duo-jie-fa-by--26/
     *
     */
    public void flatten(TreeNode root) {
        //先序遍历  根左右
        while (root != null) {
            //左子树为 null，直接考虑下一个节点
            if (root.left == null) {
                root = root.right;
            } else {
                // 找左子树最右边的节点 为了把 右子树拼上
                TreeNode pre = root.left;
                while (pre.right != null) {
                    pre = pre.right;
                }
                //将原来的右子树接到左子树的最右边节点
                pre.right = root.right;
                // 将左子树插入到右子树的地方
                root.right = root.left;
                root.left = null;
                // 考虑下一个节点
                root = root.right;
            }
        }

    }
}
