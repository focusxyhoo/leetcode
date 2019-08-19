package medium;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class T15_3Sum {

    // brute force
    // 没有考虑去重
    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new LinkedList<>();
        for (int i = 0; i < nums.length - 3; i++) {
            for (int j = i + 1; j < nums.length - 2; j++) {
                for (int k = i + 2; k < nums.length - 1; k++) {
                    if (nums[i] + nums[j] + nums[k] == 0) {
                        if (!result.contains(List.of(nums[i], nums[j], nums[k])))
                            result.add(List.of(nums[i], nums[j], nums[k]));
                    }
                }
            }
        }
        return result;
    }

    // 首先是对原数组进行排序
    // 首先对所有可能的第一个元素进行遍历，然后利用两数之和的思路来求解三元组的另外两个元素
    public static List<List<Integer>> threeSum2(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new LinkedList<>();
        for (int i = 0; i < nums.length - 2; i++) {
            // if语句这里跳过了重复数字
            if (i == 0 || (i > 0 && nums[i] != nums[i - 1])) {
                // 满足条件的，直接利用两数之和的求解思路
                int low = i + 1;
                int high = nums.length - 1;
                int sum = 0 - nums[i];
                while (low < high) {
                    if (nums[low] + nums[high] == sum) {
                        result.add(Arrays.asList(nums[i], nums[low], nums[high]));
                        // 下面两个while循环也跳过了重复数字
                        while (low < high && nums[low] == nums[low + 1])
                            low++;
                        while (low < high && nums[high] == nums[high - 1])
                            high--;
                        low++;
                        high--;
                    } else if (nums[low] + nums[high] > sum) {
                        high--;
                    } else
                        low ++;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {

        int[] nums = {-1, 0, 1, 2, -1, -4};
        List<List<Integer>> result = threeSum(nums);
        System.out.println(result);
        List<List<Integer>> result2 = threeSum2(nums);
        System.out.println(result2);


    } 
}