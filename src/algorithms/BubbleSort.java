package algorithms;

import java.util.Arrays;

/**
 * created with IntelliJ IDEA
 * author      : focusxyhoo
 * date        : 2019-08-14
 * time        : 23:13
 * description : 冒泡排序
 */
public class BubbleSort {
    public static void main(String[] args) {
        int[] nums = {8, 7, 6, 5, 4, 3, 2, 1, 0};
        bubbleSort(nums);
        System.out.println(Arrays.toString(nums));
    }

    public static void bubbleSort(int[] nums) {
        int n = nums.length;
        if (null == nums || n == 0) return;
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if (nums[i] > nums[j]) swap(nums, i, j);
            }
        }
    }

    public static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
