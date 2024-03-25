package 二叉树;
/**
 * https://leetcode.cn/problems/merge-two-binary-trees/
 * easy
 * 合并的规则是：如果两个节点重叠，那么将这两个节点的值相加作为合并后节点的新值；否则，不为 null 的节点将直接作为新二叉树的节点。
 */
public class 合并二叉树 {

// https://leetcode.cn/problems/merge-two-binary-trees/solution/dong-hua-yan-shi-di-gui-die-dai-617he-bing-er-cha-/

    /**
     * 递归 dfs
     * @param root1
     * @param root2
     * @return
     */
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        if(root1 == null && root2 == null) return null;
        if(root1 == null || root2 == null) return root1 == null ? root2 : root1;
        root1.val += root2.val;
        root1.left = mergeTrees(root1.left,root2.left);
        root1.right = mergeTrees(root1.right,root2.right);
        return root1;

    }

}
