package 二叉树;

import java.util.HashMap;
import java.util.Map;
import java.util.Arrays;

/**
 * https://leetcode.cn/problems/construct-binary-tree-from-preorder-and-inorder-traversal/
 * medium
 * 给定两个整数数组 preorder 和 inorder ，其中preorder 是二叉树的先序遍历， inorder是同一棵树的中序遍历，请构造二叉树并返回其根节点。
 * 分治法，根据前序遍历得到根节点，根据中序遍历 把左子树 和右子树切开 然后递归 最终生成一棵树
 *
  <img width="640" height="320" src="./img/前序中序构造树.png"  alt="">
 *
 */
public class 从前序与中序遍历序列构造二叉树 {

    private int[] preorder;
    private Map<Integer, Integer> hash;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int preLen = preorder.length;
        int inLen = inorder.length;
        if (preLen != inLen) {
            throw new RuntimeException("Incorrect input data.");
        }
        this.preorder = preorder;
        //使用hashmap快速找到中序遍历的跟所在位置来切断数组
        this.hash = new HashMap<>();
        for (int i = 0; i < inLen; i++) {
            hash.put(inorder[i], i);
        }

        return buildTree(0, preLen - 1, 0, inLen - 1);
    }

    /**
     *
     * @param preLeft  前序遍历左边界
     * @param preRight 前序遍历右边界
     * @param inLeft   中序遍历左边界
     * @param inRight  中序遍历右边界
     * @return 树
     */
    private TreeNode buildTree(int preLeft, int preRight, int inLeft, int inRight) {
        // 因为是递归调用的方法，按照国际惯例，先写递归终止条件
        if (preLeft > preRight || inLeft > inRight) {
            return null;
        }
        // 先序遍历的起点就是树的根
        int pivot = preorder[preLeft];
        TreeNode root = new TreeNode(pivot);
        // 从hashmap中拿到根节点在数组中的位置
        int pivotIndex = hash.get(pivot);
        //找这个边界算难点
        /**
         * 前2个参数是前序数组的，后2个参数是中序数组
         * 第一个参数 除去根元素 所以是pre+1
         * 第二个参数 根据图可以 左子树长度可以由 中序分好的左子树可得即：pivotIndex - inLeft  - 1,在回到前序遍历加上起始位置
         * 就可得 前序遍历的右边界即：pivotIndex - inLeft  - 1+ preLeft + 1 省去数字 最终：pivotIndex - inLeft + preLeft
         * 第三个参数 中序遍历的第一个元素
         * 第四个参数 根节点位置减1 可得
         */
        root.left = buildTree(preLeft + 1, pivotIndex - inLeft + preLeft,
                inLeft, pivotIndex - 1);
        /**
         * 第一个参数  前序遍历中找到的左子树的结尾加上1 可得
         * 第二个参数  前序遍历的尾
         * 第三个参数  中序遍历找到的根节点 加上1 可得
         * 第四个参数  中序遍历的跟就是所求
         */
        root.right = buildTree(pivotIndex - inLeft + preLeft + 1, preRight,
                pivotIndex + 1, inRight);
        return root;
    }


    /**
     * https://leetcode.cn/problems/construct-binary-tree-from-preorder-and-inorder-traversal/solution/dong-hua-yan-shi-105-cong-qian-xu-yu-zhong-xu-bian/
     *
     */
    public TreeNode buildTree2(int[] preorder, int[] inorder) {
        if(preorder.length==0 || inorder.length==0) {
            return null;
        }
        //根据前序数组的第一个元素，就可以确定根节点
        TreeNode root = new TreeNode(preorder[0]);
        for(int i=0;i<preorder.length;++i) {
            //用preorder[0]去中序数组中查找对应的元素
            if(preorder[0]==inorder[i]) {
                //将前序数组分成左右两半，再将中序数组分成左右两半
                //之后递归的处理前序数组的左边部分和中序数组的左边部分
                //递归处理前序数组右边部分和中序数组右边部分
                int[] pre_left = Arrays.copyOfRange(preorder,1,i+1);
                int[] pre_right = Arrays.copyOfRange(preorder,i+1,preorder.length);
                int[] in_left = Arrays.copyOfRange(inorder,0,i);
                int[] in_right = Arrays.copyOfRange(inorder,i+1,inorder.length);
                root.left = buildTree(pre_left,in_left);
                root.right = buildTree(pre_right,in_right);
                break;
            }
        }
        return root;
    }



}
