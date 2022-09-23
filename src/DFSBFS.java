import java.util.LinkedList;
import java.util.Stack;


/**
 * https://www.cnblogs.com/bruce1992/p/15135876.html
 */
public class DFSBFS {


    class Node{
        char data;
        Node leftChild;
        Node rightChild;
    }

    /**
     * DFS实现：
     * 数据结构：栈
     * 遍历操作：父节点入栈，父节点出栈，先右子节点入栈，后左子节点入栈，递归遍历全部节点。
     * @param rNode
     */
    public void depthFirstSearch(Node rNode) {
        Stack<Node> stack  = new Stack();
        stack.push(rNode);
        Node node = null;
        while (!stack.empty()) {
            node = stack.pop();
            System.out.println(node.data);//遍历根节点
            if (node.rightChild != null) {
                stack.push(node.rightChild);//先存右子树
            }
            if (node.leftChild != null) {
                stack.push(node.leftChild);//再将左子树压栈
            }
        }
    }


    /**
     * BFS实现：
     * 数据结构：队列
     * 遍历操作：父节点入队列，父节点出队列，先左子节点入队列，后右子节点处队列，递归遍历全部节点。
     * @param rnode
     */
    public void breadFirstSearch(Node rnode) {
        LinkedList<Node> queue = new LinkedList<>();
        queue.offer(rnode);
        Node node = null;
        while (!queue.isEmpty()){
            node = queue.poll();
            System.out.println(node.data);//遍历根节点
            if (node.leftChild != null) {
                queue.offer(node.leftChild);
            }

            if (node.rightChild != null) {
                queue.offer(node.rightChild);
            }
        }
    }

}
