package leetcode.medium;

/**
 * created with IntelliJ IDEA
 * author      : focusxyhoo
 * date        : 2019-07-10
 * time        : 20:23
 * description : https://leetcode.com/problems/house-robber-ii/
 */
public class T213_HouseRobberII {
    public static void main(String[] args) {
        int[] nums = {2, 3, 2};
        System.out.println(rob(nums));

    }

    public static int rob(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];

        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);

        if ((nums.length & 1) == 0) { // 当长度为偶数时
            for (int i = 2; i < nums.length; i++) {
                dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
            }
        } else {
            for (int i = 2; i < nums.length; i++) {
                if (i != nums.length - 1) {
                    dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
                } else dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i] - nums[0]);
            }
        }
        return dp[nums.length - 1];
    }
}
