package leetcode.easy;

import java.util.Arrays;

/**
 * created with IntelliJ IDEA
 * author      : focusxyhoo
 * date        : 2019-06-21
 * time        : 10:23
 * description : 从有序数组中删除重复的元素，并返回没有重复元素的数组大小。
 * 思路一：空间换时间。遍历数组，利用一个 set 集合保存元素，最后返回 set 集合的 size
 * 思路二：充分利用数组有序这一信息（重复的元素一定都是相邻的），通过两个下标，将不重复的元素往前移，最后返回后面的下标 + 1
 */
public class T26_RemoveDuplicatesFromSortedArray {

    public static void main(String[] args) {
        int[] nums = {1, 1, 3, 4, 4, 5};
        System.out.println(removeDuplicates(nums));
        System.out.println(Arrays.toString(nums));
    }

    public static int removeDuplicates(int[] nums) {
        if (nums.length == 0) return 0;
        int i = 0;
        for (int j = 1; j < nums.length; j++) {
            if (nums[j] != nums[i]) {
                i++;
                nums[i] = nums[j];
            }
        }
        return i + 1;
    }
}
