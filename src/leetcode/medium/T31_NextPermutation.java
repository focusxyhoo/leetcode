package medium;

import java.util.Arrays;

/**
 * @author focusxyhoo
 * @date 2019-05-05 17:59
 */
public class T31_NextPermutation {
    /**
     * 题目意思是说，对一个数组，按查字典的顺序进行排列，找出给出数组的下一个排列。
     * 如果已经是最后一行，就重排成第一行。
     * 比如 abcd，下一个是abdc，接着是：acbd -> acdb -> adbc -> adcb -> ...
     * 换成数字也可以一样。
     * 规律：
     * 任何逆序的序列都没有下一个更大的 permutation。
     *
     * @param nums
     */
    public static void nextPermutation(int[] nums) {
        int len = nums.length;
        // 讨论数组为空的情况。
        if (len == 0) {
            return;
        }
        // 从后往前开始遍历，找出不为递增的位置 index。
        // 注意等号一定要有。
        int index = len - 1;
        while (index > 0 && nums[index - 1] >= nums[index]) {
            index--;
        }
        // 这里同时考虑了数组长度为零，以及最后一行的情况。
        if (index == 0) {
            Arrays.sort(nums);
            return;
        }
        // 在 index 后面的子数组中查找比 nums[index] 第一大的值，记为 target，及其位置 targetIndex。
        int target = Integer.MAX_VALUE, targetIndex = Integer.MAX_VALUE;
        for (int i = len - 1; i >= index - 1; i--) {
            if (nums[i] > nums[index - 1] && nums[i] < target) {
                target = nums[i];
                targetIndex = i;
            }
        }
        // 交换 index - 1 与 targetIndex 的值
        int temp = nums[index - 1];
        nums[index - 1] = nums[targetIndex];
        nums[targetIndex] = temp;

        // index - 1 后的子数组按升序排序
        Arrays.sort(nums, index, len);
    }

    // 思路与上面相同，只是写法相对更好一些。
    public static void nextPermutation2(int[] nums) {
        int i = nums.length - 2;
        while (i >= 0 && nums[i + 1] <= nums[i]) {
            i--;
        }
        if (i >= 0) {
            int j = nums.length - 1;
            while (j >= 0 && nums[j] <= nums[i]) {
                j--;
            }
            swap(nums, i, j);
        }
        reverse(nums, i + 1);
    }
    // 颠倒数组 nums 从 start 位置开始到末尾的顺序。
    private static void reverse(int[] nums, int start) {
        int i = start, j = nums.length - 1;
        while (i < j) {
            swap(nums, i, j);
            i++;
            j--;
        }
    }
    // 交换数组 nums 两个指定位置上的元素。
    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        int[] nums = {3,1,2,2};
//        int[] nums = {1};
        nextPermutation2(nums);
        for (int i = 0; i < nums.length; i++){
            System.out.println(nums[i]);
        }
    }
}
