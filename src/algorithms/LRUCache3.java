package algorithms;
// Runtime: 55 ms, faster than 98.78% of Java online submissions for LRU Cache.
// Memory Usage: 52.5 MB, less than 88.57% of Java online submissions for LRU Cache.

import java.util.HashMap;
import java.util.Map;

public class LRUCache3 {

    private class Node {
        int key, value;
        Node next, prev;

        Node (int key, int value) {
            this.key = key;
            this.value = value;
        }

        Node () {
            this(0, 0);
        }
    }

    private int size, capacity;
    private Map<Integer, Node> map;
    private Node head, tail;

    public LRUCache3(int capacity) {
        this.capacity = capacity;
        size = 0;
        map = new HashMap<>();
        head = new Node();
        tail = new Node();
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        Node index = map.get(key);
        if (null == index) return -1;
        update(index);
        return index.value;
    }

    public void put(int key, int value) {
        Node index = map.get(key);
        if (null == index) {
            Node newNode = new Node(key, value);
            map.put(key, newNode);
            addFirst(newNode);
            size++;
        } else {
            index.value = value;
            update(index);
        }
        if (size > capacity) {
            Node last = tail.prev;
            remove(last);
            map.remove(last.key);
            size--;
        }

    }


    private void update(Node p) {
        remove(p);
        addFirst(p);
    }

    private void remove(Node p) {
        Node before = p.prev, after = p.next;
        before.next = after;
        after.prev = before;
    }

    private void addFirst(Node p) {
        Node after = head.next;
        head.next = p;
        p.prev = head;
        p.next = after;
        after.prev = p;
    }


    public static void main(String[] args) {
        LRUCache3 cache = new LRUCache3(2);

        cache.put(2, 1);
        cache.put(1, 1);
        cache.put(2, 3);
        cache.put(4, 1);

        System.out.println(cache.get(1));
        System.out.println(cache.get(2));
    }
}

