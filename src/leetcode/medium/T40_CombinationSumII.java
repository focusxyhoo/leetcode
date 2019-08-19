package medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * created with IntelliJ IDEA
 * author      : focusxyhoo
 * date        : 2019-06-12
 * time        : 14:47
 * description : 类似上一题。不过 nums 可以有重复的元素，但是 nums 中的元素只能使用一次。
 */
public class T40_CombinationSumII {
    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {

        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(candidates);
        backtrack(list, new ArrayList<>(), candidates, target, 0);
        return list;
    }

    public static void backtrack(List<List<Integer>> list, List<Integer> tempList, int[] nums, int remain, int start) {
        if (remain < 0) return;
        else if (remain == 0) list.add(new ArrayList<>(tempList));
        else {
            for (int i = start; i < nums.length; i++) {
                if (i > start && nums[i] == nums[i - 1]) continue;
                tempList.add(nums[i]);
                backtrack(list, tempList, nums, remain - nums[i], i + 1);
                tempList.remove(tempList.size() - 1);
                if (remain - nums[i] <= 0)
                    break;
            }
        }
    }

    public static void main(String[] args) {
        List<List<Integer>> list = combinationSum2(new int[]{10, 1, 2, 7, 6, 1, 5}, 8);
        System.out.println(list.toString());
    }
}
