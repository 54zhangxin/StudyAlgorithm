package 二叉树;

import java.util.LinkedList;

/**
 * https://leetcode.cn/problems/dui-cheng-de-er-cha-shu-lcof/
 * easy
 * 给你一个二叉树的根节点 root ， 检查它是否轴对称。
 * 将根节点的左子树记做 left，右子树记做 right。比较 left 是否等于 right，不等的话直接返回就可以了。
 * 如果相当，比较 left 的左节点和 right 的右节点，再比较 left 的右节点和 right 的左节点
 * 比如看下面这两个子树(他们分别是根节点的左子树和右子树)，能观察到这么一个规律：
 * 左子树 2 的左孩子 == 右子树 2 的右孩子
 * 左子树 2 的右孩子 == 右子树 2 的左孩子
 *     2         2
 *    / \       / \
 *   3   4     4   3
 *  / \ / \   / \ / \
 * 8  7 6  5 5  6 7  8
 */
public class 对称二叉树 {

    //https://leetcode.cn/problems/symmetric-tree/solution/dong-hua-yan-shi-101-dui-cheng-er-cha-shu-by-user7/
    public boolean isSymmetric(TreeNode root) {
        return root == null ? true : recur(root.left, root.right);
    }

    boolean recur(TreeNode L, TreeNode R) {
        //递归的终止条件是两个节点都为空
        //或者两个节点中有一个为空
        //或者两个节点的值不相等
        if (L == null && R == null) {
            return true;
        }
        if (L == null || R == null || L.val != R.val) {
            return false;
        }
        return recur(L.left, R.right) && recur(L.right, R.left);
    }


    /**
     * 迭代法  借用队
     *
     */

    public boolean isSymmetric2(TreeNode root) {
        if (root == null || (root.left == null && root.right == null)) {
            return false;
        }
        //用队列保存节点
        LinkedList<TreeNode> queue = new LinkedList<>();
        //将根节点的左右孩子放到队列中
        queue.add(root.left);
        queue.add(root.right);
        while (queue.size() > 0) {
            //  从队列中取出两个节点，在比较这两个节点
            TreeNode left = queue.removeFirst();
            TreeNode right = queue.removeFirst();
            //如果两个节点都为空就继续循环，两者有一个为空就返回false
            if (left == null && right == null) {
                continue;
            }

            if (left == null || right == null) {
                return false;
            }
            //将左节点的左孩子，右节点的有孩子放入队列
            queue.add(left.left);
            queue.add(right.right);

            queue.add(left.right);
            queue.add(right.left);
        }
        return true;
    }

}
