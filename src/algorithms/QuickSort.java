package algorithms;

import java.util.Arrays;

/**
 * created with IntelliJ IDEA
 * author      : focusxyhoo
 * date        : 2019-08-15
 * time        : 09:46
 * description : 快速排序
 */
public class QuickSort {
    public static void main(String[] args) {
        int[] nums = {3, 2, 7, 6, 8, 9, 5, 1, 4};
        quickSort(nums);
        System.out.println(Arrays.toString(nums));
    }

    public static void quickSort(int[] nums) {
        if (null == nums || nums.length == 0) return;
        core(nums, 0, nums.length - 1);
    }

    private static void core(int[] nums, int left, int right) {
        if (left >= right) return;
        int pivotPos = partition2(nums, left, right);
        core(nums, left, pivotPos - 1);
        core(nums, pivotPos + 1, right);
    }

    // 一次划分
    private static int partition(int[] nums, int left, int right) {
        int pivotPos = left;
        int pivotValue = nums[left];
        while (left < right) {
            while (left < right && nums[right] >= pivotValue) right--;
            while (left < right && nums[left] <= pivotValue) left++;
            BubbleSort.swap(nums, left, right);
        }
        BubbleSort.swap(nums, left, pivotPos);
        return left;
    }

    // 对 partition 的优化，减少比较次数
    private static int partition2(int[] nums, int left, int right) {
        int pivotValue = nums[left];
        while (left < right) {
            while (left < right && nums[right] >= pivotValue) right--; // while 循环不执行时，left == right，因此这两条执行语句没有影响
            nums[left] = nums[right];
            while (left < right && nums[left] <= pivotValue) left++;
            nums[right] = nums[left];
        }
        nums[left] = pivotValue;
        return left;
    }


}
