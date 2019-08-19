package hard;

/**
 * created with IntelliJ IDEA
 * author      : focusxyhoo
 * date        : 2019-07-12
 * time        : 09:28
 * description :
 */
public class T460_LFUCache {

    private class Node {
        int key, value;
        int count;

        Node(int key, int value) {
            this.key = key;
            this.value = value;
            count = 0;
        }
    }

    private Node[] cache;
    int size;

    public T460_LFUCache(int capacity) {
        cache = new Node[capacity];
        size = 0;

    }

    public int get(int key) {
        for (int i = 0; i < size; i++) {
            if (key == cache[i].key) {
                cache[i].count++;
                return cache[i].value;
            }
        }
        return -1;
    }

    public void put(int key, int value) {
        if (cache == null || cache.length == 0) return;
        int index = find(key);
        if (index != -1) {
            cache[index].value = value;
            cache[index].count++;
        } else {
            if (size < cache.length) {
                cache[size] = new Node(key, value);
                size++;
            } else {
                int indexMinCount = findMinCount(key);
                cache[indexMinCount] = new Node(key, value);
            }
        }
    }

    private int find(int key) {
        for (int i = 0; i < size; i++) {
            if (key == cache[i].key) return i;
        }
        return -1;
    }

    private int findMinCount(int key) {
        int index = 0;
        int minCount = Integer.MAX_VALUE;
        for (int i = 0; i < size; i++) {
            if (cache[i].count < minCount) {
                minCount = cache[i].count;
                index = i;
            }
        }
        return index;
    }

    public static void main(String[] args) {
        T460_LFUCache cache = new T460_LFUCache(2);
        cache.put(1, 1);
        cache.put(2, 2);
        System.out.println(cache.get(1));
        cache.put(3, 3);
        System.out.println(cache.get(2));
        System.out.println(cache.get(3));
        cache.put(4, 4);
        System.out.println(cache.get(1));
        System.out.println(cache.get(3));
        System.out.println(cache.get(4));

    }
}
