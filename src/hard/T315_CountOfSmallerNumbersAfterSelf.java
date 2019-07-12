package hard;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * created with IntelliJ IDEA
 * author      : focusxyhoo
 * date        : 2019-07-06
 * time        : 20:36
 * description :
 */
public class T315_CountOfSmallerNumbersAfterSelf {

    public static void main(String[] args) {

    }

    /**
     * Runtime: 350 ms, faster than 14.58% of Java online submissions for Count of Smaller Numbers After Self.
     * Memory Usage: 39.9 MB, less than 86.49% of Java online submissions for Count of Smaller Numbers After Self.
     *
     * @param nums
     * @return
     */
    public static List<Integer> countSmaller(int[] nums) {
        List<Integer> ans = new LinkedList<>();
        for (int i = 0; i < nums.length; i++) {
            int count = 0;
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] > nums[j]) count++;
            }
            ans.add(count);
        }
        return ans;
    }


    // 以下这三种方法来自：
    // https://leetcode.com/problems/count-of-smaller-numbers-after-self/discuss/76674/3-Ways-(Segment-Tree-Binary-Indexed-Tree-Merge-Sort)-clean-Java-code

    /**
     * Segment Tree
     *
     * @param nums
     * @return
     */
    public static List<Integer> countSmaller2(int[] nums) {
        List<Integer> list = new LinkedList<>();

        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        for (int i : nums) {
            min = min > i ? i : min;
            max = max < i ? i : max;
        }

        SegmentTreeNode root = new SegmentTreeNode(min, max);

        for (int i = nums.length - 1; i >= 0; i--) {
            list.add(0, find(nums[i] - 1, root));
            add(nums[i], root);
        }
        return list;
    }

    static class SegmentTreeNode {
        int min, max;
        int count;
        SegmentTreeNode left, right;

        public int mid() {
            return (max + 1 - min) / 2 + min;
        }

        public SegmentTreeNode(int min, int max) {
            this.min = min;
            this.max = max;
            count = 0;
        }
    }

    private static int find(int x, SegmentTreeNode root) {
        if (root == null) return 0;
        if (x >= root.max) return root.count;
        else {
            int mid = root.mid();
            if (x < mid) return find(x, root.left);
            else return find(x, root.left) + find(x, root.right);
        }
    }

    private static void add(int x, SegmentTreeNode root) {
        if (x < root.min || x > root.max) return;

        root.count++;
        if (root.min == root.max) return;

        int mid = root.mid();
        if (x < mid) {
            if (root.left == null) root.left = new SegmentTreeNode(root.min, mid - 1);
            add(x, root.left);
        } else {
            if (root.right == null) root.right = new SegmentTreeNode(mid, root.max);
            add(x, root.right);
        }
    }


    /**
     * Binary Indexed Tree BIT
     *
     * @param nums
     * @return
     */
    public static List<Integer> countSmaller3(int[] nums) {

        List<Integer> ans = new ArrayList<>();
        if (nums == null || nums.length == 0) return ans;

        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            min = nums[i] < min ? nums[i] : min;

        }
        int[] nums2 = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            nums2[i] = nums[i] - min + 1;
            max = Math.max(nums2[i], max);
        }
        int[] tree = new int[max + 1];
        for (int i = nums2.length - 1; i >= 0; i--) {
            ans.add(0, get(nums2[i] - 1, tree));
            update(nums2[i], tree);
        }
        return ans;
    }

    private static int get(int i, int[] tree) {
        int num = 0;

        while (i > 0) {
            num += tree[i];
            i -= i & (-i);
        }
        return num;
    }

    private static void update(int i, int[] tree) {
        while (i < tree.length) {
            tree[i]++;
            i += i & (-i);
        }
    }


    /**
     * Merge Sort
     *
     * @param nums
     * @return
     */
    public static List<Integer> countSmaller4(int[] nums) {

        int len = nums == null ? 0 : nums.length;

        int[] idx = new int[len];
        int[] count = new int[len];

        for (int i = 0; i < len; i++) idx[i] = i;

        mergeSort(nums, idx, count, 0, len);

        List<Integer> list = new ArrayList<>();
        for (int i : count) {
            list.add(i);
        }

        return list;
    }

    private static void mergeSort(int[] nums, int[] idx, int[] count, int start, int end) {
        if (start + 1 >= end) return;

        int mid = (end - start) / 2 + start;
        mergeSort(nums, idx, count, start, mid);
        mergeSort(nums, idx, count, mid, end);

        merge(nums, idx, count, start, end);

    }

    private static void merge(int[] nums, int[] idx, int[] count, int start, int end) {
        int mid = (end - start) / 2 + start;

        int[] temp = new int[end - start];
        int[] tempIdx = new int[end - start];
        int i = start, j = mid, k = 0;
        while (k < end - start) {
            if (i < mid) {
                if (j < end && nums[j] < nums[i]) {
                    tempIdx[k] = idx[j];
                    temp[k++] = nums[j++];
                } else {
                    count[idx[i]] += j - mid;
                    tempIdx[k] = idx[i];
                    temp[k++] = nums[i++];
                }
            } else {
                tempIdx[k] = idx[j];
                temp[k++] = nums[j++];
            }
        }
        System.arraycopy(tempIdx, 0, idx, start, end - start);
        System.arraycopy(temp, 0, nums, start, end - start);
    }

}