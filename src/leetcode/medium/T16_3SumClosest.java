package leetcode.medium;

import java.util.Arrays;

public class T16_3SumClosest {

    // 想清楚思路之后再来写代码
    public static int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int result = nums[0] + nums[1] + nums[nums.length - 1];

        for (int i = 0; i < nums.length - 2; i++) {
            int low = i + 1;
            int high = nums.length - 1;
            while (low < high) {
                int sum = nums[i] + nums[low] + nums[high];
                if (sum > target)
                    high--;
                else
                    low++;
                if (Math.abs(sum - target) < Math.abs(result - target))
                    result = sum;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {1, -1, 4, 2};
        System.out.println(threeSumClosest(nums, 1));
    }
}
