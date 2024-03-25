package 二叉树;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * https://leetcode.cn/problems/binary-tree-right-side-view/
 * medium
 * 给定一个二叉树的 根节点 root，想象自己站在它的右侧， 按照从顶部到底部的顺序，返回从右侧所能看到的节点值。
 */
public class 二叉树的右视图 {
    /**
     * 层序遍历BFS 记录每一层最后一个节点
     */
    public List<Integer> rightSideView(TreeNode root) {

        List<Integer> res = new ArrayList<>();//创建一个存储答案的list
        if (root == null) {
            return res;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);// 把树根节点添加到队列中

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();//从队列中返回第一个元素，并在队列中删除
                if (node==null){
                    break;
                }
                if (node.left != null) {
                    queue.offer(node.left);// 把左节点加入到队列中
                }

                if (node.right != null) {
                    queue.offer(node.right);//把右节点接入到队列中
                }
                //将当前层的最后一个接点放入结果列表
                if (i == size - 1) {
                    res.add(node.val);
                }
            }
        }

        return res;
    }
}
