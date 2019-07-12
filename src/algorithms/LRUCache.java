package algorithms;


import structure.Node;

import java.util.LinkedList;
import java.util.List;


/**
 * created with IntelliJ IDEA
 * author      : focusxyhoo
 * date        : 2019-07-11
 * time        : 14:25
 * description : 用单链表来实现 LRU。
 */
public class LRUCache {

    private List<Node> cache;
    private int size;
    private int capacity;
    private Node root;

    public LRUCache(int capacity) {
        cache = new LinkedList<>();
        size = 0;
        this.capacity = capacity;

    }

    public int get(int key) {

        return -1;
    }

    public void put(int key, int value) {

    }

    private Node containsKey(int key) {

        Node curr = root;
        while (curr != null) {

        }
        return null;
    }


    public static void main(String[] args) {
        LRUCache cache = new LRUCache(2);

    }
}


