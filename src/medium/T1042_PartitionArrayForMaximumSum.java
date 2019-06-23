package medium;

/**
 * created with IntelliJ IDEA
 * author      : focusxyhoo
 * date        : 2019-06-23
 * time        : 12:20
 * description : 优化问题。
 * 先看数据规模。500-1000的数据规模，一般暗示的时间复杂度是O(n^2)或者是O(nk)。
 * greedy is not suitable for this.
 * dp。指定状态。用子问题的解来解决原问题。
 * 一维dp。初始化dp[0]=0。dp[i]表示有i个元素的数组的最大值。
 * dp[1] = max(dp[0] + max(num[1])*1)
 * dp[2] = max(dp[0])
 */
public class T1042_PartitionArrayForMaximumSum {

    public static void main(String[] args) {

        // partition 后的结果是 15*3+9+10*3=84
        int[] nums = {1, 15, 7, 9, 2, 5, 10};
        System.out.println(maxSumAfterPartition(nums, 3));

    }

    public static int maxSumAfterPartition(int[] nums, int k) {

        int n = nums.length;
        int[] dp = new int[n + 1];
        dp[0] = 0;

        for (int i = 1; i <= n; i++) {
            int min = Integer.MIN_VALUE;
            for (int j = 1; j <= Math.min(i, k); ++j) {
                min = Math.max(min, nums[i - j]);
                dp[i] = Math.max(dp[i], dp[i - j] + min * j);
            }
        }
        return dp[n];
    }
}
