package medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * created with IntelliJ IDEA
 * author      : focusxyhoo
 * date        : 2019-08-06
 * time        : 16:07
 * description : https://leetcode.com/problems/subsets/
 * 求给出集合（不包含重复元素）的所有子集。
 */
public class T78_Subsets {
    public static void main(String[] args) {
        int[] nums = {1, 3, 2};
        List<List<Integer>> result = subsets(nums);
        for (List<Integer> list : result) {
            System.out.println(list);
        }
    }

    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
//        Arrays.sort(nums);
        backtrack(list, new ArrayList<>(), nums, 0);
        return list;
    }

    private static void backtrack(List<List<Integer>> list, List<Integer> tempList, int[] nums, int start) {
        list.add(new ArrayList<>(tempList));
        for (int i = start; i < nums.length; i++) {
            tempList.add(nums[i]);
            backtrack(list, tempList, nums, i + 1);
            tempList.remove(tempList.size() - 1);
        }
    }
}
