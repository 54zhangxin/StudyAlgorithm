import java.util.HashMap;
import java.util.Map;


/**
 * 不用LintedHashMap 手动双链表+HashMap
 */
public class LruCache2 {
    int capacity;
    int size;
    Node head;
    // 定义一个K为Int的，V 为Node 的map
    Map<Integer, Node> map = new HashMap<>();

    static class Node {
        int key;
        int val;
        Node next;
        Node prev;

        Node() {
        }

        Node(int key, int val) {
            this.key = key;
            this.val = val;
        }

        Node remove() {
            prev.next = next;
            next.prev = prev;
            next = null;
            prev = null;
            return this;
        }

        void insert(Node node) {
            node.next = next;
            node.prev = this;
            next.prev = node;
            next = node;
        }
    }

    public LruCache2(int capacity) {
        this.capacity = capacity;
        head = new Node();
        head.next = head;
        head.prev = head;
    }


    public int get(int key) {
        Node node = map.get(key);
        if (node == null) return -1;

        node = node.remove();
        head.insert(node);
        return node.val;
    }

    public void put(int key, int value) {
        Node node = map.get(key);
        if (node == null) {
            node = new Node(key, value);
            map.put(key, node);
            size++;
        } else {
            node = node.remove();
            node.val = value;
        }

        head.insert(node);
        if (size > capacity) {
            Node removed = head.prev.remove();
            map.remove(removed.key);
            size--;
        }
    }

}
