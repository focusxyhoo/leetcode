package medium;

import java.util.Arrays;

/**
 * created with IntelliJ IDEA
 * author      : focusxyhoo
 * date        : 2019-06-25
 * time        : 16:56
 * description : https://leetcode.com/problems/longest-increasing-subsequence/
 * 另外还有一个 nlogn 的方法。
 */
public class T300_LongestIncreasingSubsequence {

    /**
     * dp
     * ~7 ms
     * time : O(n^2)
     *
     * @param nums
     * @return
     */
    public int lengthOFLIS(int[] nums) {
        int n = nums.length;
        if (n == 0) return 0;

        // define and initialize the dp array
        // dp[i] : the length of LIS in nums[0:i]
        int[] dp = new int[n];
        Arrays.fill(dp, 1);

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }
        return maxInArray(dp);
    }

    private int maxInArray(int[] nums) {
        int max = Integer.MIN_VALUE;
        for (int x : nums) {
            if (x > max) max = x;
        }
        return max;
    }

}
