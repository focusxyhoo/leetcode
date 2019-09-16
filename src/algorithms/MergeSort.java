package algorithms;

import java.util.Arrays;

/**
 * created with IntelliJ IDEA
 * author      : focusxyhoo
 * date        : 2019-08-15
 * time        : 10:32
 * description : 归并排序
 */
public class MergeSort {
    public static void main(String[] args) {
        int[] nums = {3, 4, 2, 6, 7, 8, 5, 1, 9};
        mergeSort(nums);
        System.out.println(Arrays.toString(nums));
    }

    public static void mergeSort(int[] nums) {
        if (null == nums || nums.length == 0) return;
        core(nums, 0, nums.length - 1);
    }

    /**
     * 递归分治
     *
     * @param nums
     * @param left
     * @param right
     */
    private static void core(int[] nums, int left, int right) {
        if (left >= right) return;
        int mid = (left + right) / 2;
        core(nums, left, mid);
        core(nums, mid + 1, right);
        merge2(nums, left, mid, right);
    }

    /**
     * 通过第三个临时数组来合并两个有效数组。
     * 第三个数组存储归并后的结果，然后再写回 nums 数组。
     *
     * @param nums
     * @param left
     * @param mid
     * @param right
     */
    private static void merge(int[] nums, int left, int mid, int right) {
        // [left, mid] [mid + 1, right]
        int[] temp = new int[right - left + 1];
        int i = left, j = mid + 1, k = 0;
        while (i <= mid && j <= right) {
            if (nums[i] <= nums[j]) temp[k++] = nums[i++];
            else temp[k++] = nums[j++];
        }
        // 如果某一边还有剩余元素
        while (i <= mid) temp[k++] = nums[i++];
        while (j <= right) temp[k++] = nums[j++];
        // 写回原数组
        for (int p = 0; p < temp.length; p++) {
            nums[left + p] = temp[p];
        }
    }

    private static int[] aux = new int[100]; // 保证长度大于 nums 即可

    /**
     * 先将 nums[left, right] 原样复制到 aux 数组中，然后再写回的时候归并。
     *
     * @param nums
     * @param left
     * @param mid
     * @param right
     */
    private static void merge2(int[] nums, int left, int mid, int right) {
        int i = left, j = mid + 1;
        for (int k = left; k <= right; k++) aux[k] = nums[k];
        for (int k = left; k <= right; k++) {
            if (i > mid) nums[k] = aux[j++];
            else if (j > right) nums[k] = aux[i++];
            else if (aux[i] < aux[j]) nums[k] = aux[i++];
            else nums[k] = aux[j++];
        }
    }
}
