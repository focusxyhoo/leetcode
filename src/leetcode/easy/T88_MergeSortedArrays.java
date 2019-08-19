package leetcode.easy;

import java.util.Arrays;

/**
 * created with IntelliJ IDEA
 * author      : focusxyhoo
 * date        : 2019-06-21
 * time        : 10:31
 * description : https://leetcode.com/problems/merge-sorted-array/
 *
 */
public class T88_MergeSortedArrays {
    public static void main(String[] args) {
        int[] nums1 = {0};
        int[] nums2 = {1};
        merge(nums1, 0, nums2, 1);
        System.out.println(Arrays.toString(nums1));
    }

    public static void merge2(int[] nums1, int m, int[] nums2, int n) {
        while (n > 0) nums1[m + n - 1] = (m == 0 || nums2[n - 1] > nums1[m - 1]) ? nums2[--n] : nums1[--m];
    }

    /**
     *
     * @param nums1
     * @param m
     * @param nums2
     * @param n
     */
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int curr = m + n - 1; // 指向合并后的末尾
        while (curr >= 0) {
            if (n == 0) return; // 当 nums2 元素全部合并完之后，就可以结束了。
            if (m == 0) { // 当 nums1 数组不取元素参与合并时，
                nums1[curr--] = nums2[--n];
                continue;
            }
            if (nums1[m - 1] > nums2[n - 1]) {
                nums1[curr--] = nums1[--m];
            } else {
                nums1[curr--] = nums2[--n];
            }
        }
    }
}
