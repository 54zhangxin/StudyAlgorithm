package 二叉树;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * https://leetcode.cn/problems/binary-tree-inorder-traversal/
 * 给定一个二叉树的根节点 root ，返回它的 中序 遍历。
 *。
 * 递归遍历
 * 前序遍历：根 - 左 - 右
 * 中序遍历：左 - 根 - 右
 * 后序遍历：左 - 右 - 根
 *。
 * 递归是重复调用函数自身实现循环。迭代是函数内某段代码实现循环。
 *。
 * !!!:前/中/后序的递归+迭代都要能默写，层序遍历也要默写
 */
public class 二叉树的中序遍历 {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        dfs(res, root);
        return res;
    }

    /**
     * 用递归实现遍历
     * @param res
     * @param root
     */
    void dfs(List<Integer> res, TreeNode root) {
        if (root == null) {
            return;
        }
        //按照 左-打印-右的方式遍历
        dfs(res, root.left);
        res.add(root.val);
        dfs(res, root.right);
    }


    /**
     * 用迭代实现  借用额外空间 栈
     */
    public List<Integer> inorderTraversal2(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        while (stack.size() > 0 || root != null) {
            //不断往左子树方向走，每走一次就将当前节点保存到栈中
            //这是模拟递归的调用
            if (root != null) {
                stack.add(root);
                root = root.left;
                //当前节点为空，说明左边走到头了，从栈中弹出节点并保存
                //然后转向右边节点，继续上面整个过程
            } else {
                TreeNode tmp = stack.pop();
                res.add(tmp.val);
                root = tmp.right;
            }
        }
        return res;
    }
    /**
     * 递归解释：
     *      1
     *   2    3
     * 4  5   6  7
     *
     * 124依次进栈
     *   |   |
     *   | 4 |
     *   | 2 |
     *   | 1 |
     *   ____  此时root为空 开始弹出栈内第一个节点 即4出栈 4的右节点还是空 继续出栈 2出栈 root 不为空 进栈 此时root 又为空了 有需要弹出
     *
     *
     */


    ///https://leetcode.cn/problems/binary-tree-inorder-traversal/comments/1988523
}
