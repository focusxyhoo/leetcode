package easy;

/**
 * created with IntelliJ IDEA
 * author      : focusxyhoo
 * date        : 2019-07-09
 * time        : 15:02
 * description : https://leetcode.com/problems/maximum-subarray/
 * 子数组之和最大
 * 思路一：brute force，两个 for 循环
 * 思路二：dp，dp[i] 表示从 0 到 i 的子数组中的最大和，
 * 比较原则是 dp[i] = Math.max(dp[i - 1] + nums[i], nums[i])
 * 然后遍历一遍即可
 */
public class T53_MaximumSubarray {
    public static void main(String[] args) {
        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println(maxSubArray(nums));
    }

    /**
     * Runtime: 55 ms
     * Memory Usage: 41.3 MB
     *
     * @param nums
     * @return
     */
    public static int maxSubArray(int[] nums) {
        int max = nums[0];
        for (int i = 0; i < nums.length; i++) {
            int temp = 0;
            for (int j = i; j < nums.length; j++) {
                temp += nums[j];
                max = Math.max(max, temp);
            }
        }
        return max;
    }

    /**
     * dp
     * Runtime: 2 ms, faster than 11.06% of Java online submissions for Maximum Subarray.
     * Memory Usage: 42 MB, less than 5.01% of Java online submissions for Maximum Subarray.
     *
     * @param nums
     * @return
     */
    public static int maxSubArray2(int[] nums) {
        if (nums == null || nums.length == 0) {
            throw new IllegalArgumentException();
        }
        // dp[i]: the maximum subarray that starts somewhere before i and ends at i.
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        int maxSum = nums[0];
        for (int i = 1; i < nums.length; i++) {
            dp[i] = Math.max(dp[i - 1] + nums[i], nums[i]);
            maxSum = Math.max(maxSum, dp[i]);
        }
        return maxSum;
    }
}
