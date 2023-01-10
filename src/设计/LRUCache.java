package 设计;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {
    class Node {
        Node prev;
        Node next;
        int key;
        int value;

        public Node() {
        }

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    int size;
    int capacity;
    Map<Integer, Node> map = new HashMap();
    Node head, tail;

    public LRUCache(int capacity) {
        this.size = 0;
        this.capacity = capacity;
        head = new Node();
        tail = new Node();
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        Node node = map.get(key);
        if (node == null) {
            return -1;
        }
        moveToHead(node);
        return node.value;
    }

    public void put(int key, int value) {
        Node node = map.get(key);
        if (node == null) {
            node = new Node(key, value);
            map.put(key, node);
            ++size;
            addToHead(node);
            if (size > capacity) {
                Node removeNode = removeTail();
                map.remove(removeNode.key);
                --size;
            }
        } else {
            node.value = value;
            moveToHead(node);

        }
    }

    public void moveToHead(Node node) {
        removeNode(node);
        addToHead(node);
    }

    public void removeNode(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    public void addToHead(Node node) {
        node.next = head.next;
        node.prev = head;

        head.next.prev = node;
        head.next = node;
    }

    public Node removeTail() {
        Node node = tail.prev;
        removeNode(node);
        return node;
    }
}
