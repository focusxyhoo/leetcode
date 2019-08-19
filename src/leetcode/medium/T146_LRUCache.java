package leetcode.medium;

import structure.Node;

/**
 * created with IntelliJ IDEA
 * author      : focusxyhoo
 * date        : 2019-07-11
 * time        : 10:45
 * description : https://leetcode.com/problems/lru-cache/
 * Runtime: 185 ms, faster than 9.34% of Java online submissions for LRU Cache.
 * Memory Usage: 61.3 MB, less than 11.09% of Java online submissions for LRU Cache.
 * O(n) : n
 */
public class T146_LRUCache {

    public static void main(String[] args) {
        T146_LRUCache cache = new T146_LRUCache(2);
        cache.put(2, 1);
        cache.put(1, 1);
        cache.put(2, 3);
        cache.put(4, 1);

        System.out.println(cache.get(1));
        System.out.println(cache.get(2));

    }


    Node[] cache;
    int[] timeStamp;
    int size;

    public T146_LRUCache(int capacity) {

        cache = new Node[capacity];
        timeStamp = new int[capacity];
        size = 0;
    }

    public int get(int key) {
        increase();

        for (int i = 0; i < size; i++) {
            if (cache[i].key == key) {
                timeStamp[i] = 0;
                return cache[i].value;
            }
        }
        return -1;
    }

    public void put(int key, int value) {
        increase();

        Node newNode = new Node(key, value);

        if (contains(key) != -1) { // node already in cache
            cache[contains(key)].value = value;
            timeStamp[contains(key)] = 0;
        } else if (size < cache.length) { // not in cache & cache not full
            cache[size] = newNode;
            timeStamp[size] = 0;
            size++;
        } else { // not in cache & cache is full
            int index = find();
            cache[index] = newNode;
            timeStamp[index] = 0;
        }
    }

    private void increase() {
        for (int i = 0; i < size; i++) {
            timeStamp[i]++;
        }
    }

    private int contains(int key) {
        for (int i = 0; i < size; i++) {
            if (cache[i].key == key) {
                return i;
            }
        }
        return -1;
    }

    private int find() {
        int max = 0;
        int index = 0;
        for (int i = 0; i < size; i++) {
            if (max < timeStamp[i]) {
                max = timeStamp[i];
                index = i;
            }
        }
        return index;
    }

}
