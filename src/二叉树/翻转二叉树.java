package 二叉树;

import java.util.LinkedList;

/**
 * https://leetcode.cn/problems/invert-binary-tree/
 * easy
 * 给你一棵二叉树的根节点 root ，翻转这棵二叉树，并返回其根节点。
 */
public class 翻转二叉树 {

    /**
     * 递归解法
     * https://leetcode.cn/problems/invert-binary-tree/solution/dong-hua-yan-shi-liang-chong-shi-xian-226-fan-zhua/
     */
    public TreeNode invertTree(TreeNode root) {
        //递归函数的终止条件，节点为空时返回
        if (root == null) {
            return null;
        }
        //下面三句是将当前节点的左右子树交换
        TreeNode tmp = root.right;
        root.right = root.left;
        root.left = tmp;
        //递归交换当前节点的 左子树
        invertTree(root.left);
        //递归交换当前节点的 右子树
        invertTree(root.right);
        //函数返回时就表示当前这个节点，以及它的左右子树
        //都已经交换完了
        return root;
    }


    /**
     * 递归实现也就是深度优先遍历的方式，那么对应的就是广度优先遍历。
     * 广度优先遍历需要额外的数据结构--队列，来存放临时遍历到的元素。
     * 深度优先遍历的特点是一竿子插到底，不行了再退回来继续；而广度优先遍历的特点是层层扫荡。
     * 所以，我们需要先将根节点放入到队列中，然后不断的迭代队列中的元素。
     * 对当前元素调换其左右子树的位置，然后：
     *
     * 判断其左子树是否为空，不为空就放入队列中
     * 判断其右子树是否为空，不为空就放入队列中
     *
     */

    public TreeNode invertTree2(TreeNode root) {
        if (root == null) {
            return null;
        }
        //将二叉树中的节点逐层放入队列中，再迭代处理队列中的元素
        LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        while (!queue.isEmpty()) {
            //每次都从队列中拿一个节点，并交换这个节点的左右子树
            TreeNode tmp = queue.poll();
            TreeNode left = tmp.left;
            tmp.left = tmp.right;
            tmp.right = left;
            //如果当前节点的左子树不为空，则放入队列等待后续处理
            if (tmp.left != null) {
                queue.add(tmp.left);
            }
            //如果当前节点的右子树不为空，则放入队列等待后续处理
            if (tmp.right != null) {
                queue.add(tmp.right);
            }

        }
        //返回处理完的根节点
        return root;
    }


}
