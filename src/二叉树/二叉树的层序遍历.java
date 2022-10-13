package 二叉树;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * medium
 * 给你一个二叉树，请你返回其按 层序遍历 得到的节点值。 （即逐层地，从左到右访问所有节点）。
 * 可参考题解：
 * https://leetcode.cn/problems/binary-tree-level-order-traversal/solution/die-dai-di-gui-duo-tu-yan-shi-102er-cha-shu-de-cen/
 */
public class 二叉树的层序遍历 {

    // 广度优先搜索 BFS 用队列实现
    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) {
            return new ArrayList<List<Integer>>();
        }
        List<List<Integer>> res = new ArrayList<>();
        LinkedList<TreeNode> queue = new LinkedList<>();
        //将根节点放入队列中，然后不断遍历队列
        queue.add(root);
        while (queue.size() > 0) {
            //获取当前列表的长度，这个长度相当于 当前这一层的节点个数
            int size = queue.size();
            ArrayList<Integer> tmp = new ArrayList<>();
            //将队列中的元素都拿出来（也就是获取这一层的节点），放到临时list中
            //如果节点的左右子树不为空，也放入队列中
            for (int i = 0; i < size; ++i) {
                TreeNode t = queue.remove();
                tmp.add(t.val);
                if (t.left != null) {
                    queue.add(t.left);
                }
                if (t.right != null) {
                    queue.add(t.right);
                }
            }

            res.add(tmp);
        }

        return res;
    }


    // DFS 深度优先遍历
    /**
     *      1
     *   2    3
     * 4  5  6  7
     * 深度 1 2 4 5 3 6 7
     * 当成梯田
     *  1
     *  2 3
     *  4 5 6 7
     *  每次递归的时候都需要带一个 index(表示当前的层数)，也就对应那个田字格子中的第几行，如果当前行对应的 list 不存在，就加入一个空 list 进去。
     *
     */

    public List<List<Integer>> levelOrderByDFS(TreeNode root) {
        if(root==null) {
            return new ArrayList<List<Integer>>();
        }
        //用来存放最终结果
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        dfs(1,root,res);
        return res;
    }

    void dfs(int index,TreeNode root, List<List<Integer>> res) {
        //假设res是[ [1],[2,3] ]， index是3，就再插入一个空list放到res中
        if(res.size()<index) {
            res.add(new ArrayList<Integer>());
        }
        //将当前节点的值加入到res中，index代表当前层，假设index是3，节点值是99
        //res是[ [1],[2,3] [4] ]，加入后res就变为 [ [1],[2,3] [4,99] ]
        res.get(index-1).add(root.val);
        //递归的处理左子树，右子树，同时将层数index+1
        if(root.left!=null) {
            dfs(index+1, root.left, res);
        }
        if(root.right!=null) {
            dfs(index+1, root.right, res);
        }
    }

}
