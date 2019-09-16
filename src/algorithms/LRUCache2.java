package algorithms;
// Runtime: 197 ms, faster than 8.52% of Java online submissions for LRU Cache.
// Memory Usage: 67.4 MB, less than 5.05% of Java online submissions for LRU Cache.

import java.util.HashMap;
import java.util.Map;

public class LRUCache2 {
    public static void main(String[] args) {
        LRUCache2 cache = new LRUCache2(2);
        cache.put(2, 1);
        cache.put(1, 1);
        cache.put(2, 3);
        cache.put(4, 1);

        System.out.println(cache.get(1));
        System.out.println(cache.get(2));
    }

    private int size;
    private int capacity;
    private Node root;
    private Map<Integer, Node> map;

    public LRUCache2(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>();
        root = null;
        size = 0;
    }

    public int get(int key) {
        Node temp = map.get(key);
        if (temp != null) {
            pushFirst(temp);
            return temp.value;
        } else {
            return -1;
        }
    }

    public void put(int key, int value) {
        if (root == null) {
            root = new Node(key, value);
            map.put(key, root);
            size++;
        } else {
            Node temp = map.get(key);
            if (temp != null) {
                temp.value = value;
                pushFirst(temp);
            } else {
                if (size == capacity) {
                    Node curr = root;
                    Node prev = curr;
                    while (curr.next != null) {
                        prev = curr;
                        curr = curr.next;
                    }
                    map.remove(curr.key);
                    if (prev == curr) curr = null;
                    else prev.next = null;
                    size--;
                }
                Node newNode = new Node(key, value);
                map.put(key, newNode);
                newNode.next = root;
                root = newNode;
                size++;
            }
        }
    }

    private void pushFirst(Node p) {
        if (size == 1) return;
        if (p == root) return;

        Node curr = root;
        while (curr.next != p) {
            curr = curr.next;
        }
        curr.next = p.next;
        p.next = root;
        root = p;
    }
}

class Node {
    int key;
    int value;
    Node next;

    public Node(int key, int value) {
        this.key = key;
        this.value = value;
        next = null;
    }
}