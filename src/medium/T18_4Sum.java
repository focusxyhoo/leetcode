package medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author focusxyhoo
 * @date 2019-04-17 12:50
 */
public class T18_4Sum {

    public static List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 3; i++) {
            if (i == 0 || (i > 0 && nums[i] != nums[i - 1])) {
                for (int j = i + 1; j < nums.length - 2; j++) {
                    if (j == i + 1 || (j > i + 1 && nums[j] != nums[j - 1])) {
                        int low = j + 1;
                        int high = nums.length - 1;
                        while (low < high) {
                            if (nums[i] + nums[j] + nums[low] + nums[high] == target) {
                                result.add(Arrays.asList(nums[i], nums[j], nums[low], nums[high]));
                                while (low < high && nums[high] == nums[high - 1]) {
                                    high--;
                                }
                                while (low < high && nums[low] == nums[low + 1]) {
                                    low++;
                                }
                                high--;
                                low++;
                            } else if (nums[i] + nums[j] + nums[low] + nums[high] > target) {
                                high--;
                            } else {
                                low++;
                            }
                        }
                    }
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {1, 0, -1, 0, -2, 2};
        int target = 0;
        System.out.println(fourSum(nums, target));

    }
}
