package algorithms;

import java.util.Arrays;

/**
 * created with IntelliJ IDEA
 * author      : focusxyhoo
 * date        : 2019-08-14
 * time        : 23:21
 * description : 简单选择排序
 */
public class SelectSort {
    public static void main(String[] args) {
        int[] nums = {8, 5, 3, 6, 2, 7, 1, 4, 9};
        selectSort(nums);
        System.out.println(Arrays.toString(nums));
    }

    public static void selectSort(int[] nums) {
        int n = nums.length;
        if (null == nums || n == 0) return;
        int maxIndex = 0;
        for (int i = n - 1; i > 0 ; i--) {
            maxIndex = i;
            for (int j = i - 1; j >= 0; j--) {
                if (nums[j] > nums[maxIndex]) maxIndex = j;
            }
            if (maxIndex != i) BubbleSort.swap(nums, i, maxIndex);
        }
    }
}
