package algorithms;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * created with IntelliJ IDEA
 * author      : focusxyhoo
 * date        : 2019-07-14
 * time        : 14:13
 * description : https://leetcode.com/problems/lru-cache/
 * Runtime: 57 ms, faster than 92.58% of Java online submissions for LRU Cache.
 * Memory Usage: 57.2 MB, less than 70.80% of Java online submissions for LRU Cache.
 */
public class LRUCache4 {

    private int capacity;
    private Map<Integer, Integer> cache;

    public LRUCache4(int capacity) {
        this.capacity = capacity;
        this.cache = new LinkedHashMap<Integer, Integer>(capacity, 0.75f, true) {

            protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
                return size() > capacity;
            }
        };
    }

    public int get(int key) {
        return cache.getOrDefault(key, -1);
    }

    public void put(int key, int value) {
        cache.put(key, value);
    }


}
