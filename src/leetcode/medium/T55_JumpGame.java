package medium;

import java.util.Arrays;

/**
 * created with IntelliJ IDEA
 * author      : focusxyhoo
 * date        : 2019-08-16
 * time        : 15:15
 * description : https://leetcode.com/problems/jump-game/
 * 题意：给定一个非负数组，每一个元素的值表示，从当前位置可以最多跳多少位，问，能否从第一位跳到最后一位？
 * 思路一：DP，dp[i] 表示从位置 i 能否到达最后一位。从后往前推。
 * 其他思路：https://leetcode.com/problems/jump-game/solution/ 介绍得非常详细
 */
public class T55_JumpGame {
    public static void main(String[] args) {
        int[] nums = {2, 3, 1, 1, 4};
        int[] nums1 = {3, 2, 1, 0, 4};
        System.out.println(canJump(nums));
        System.out.println(canJump(nums1));
    }

    /**
     * dp
     * Runtime: 139 ms, faster than 30.08% of Java online submissions for Jump Game.
     * Memory Usage: 40.8 MB, less than 52.14% of Java online submissions for Jump Game.
     * 运行结果并不理想，毕竟嵌套了两层循环，时间复杂度最差到 O(n^2)
     *
     * @param nums
     * @return
     */
    public static boolean canJump(int[] nums) {
        int n = nums.length;
        boolean[] dp = new boolean[n];
        Arrays.fill(dp, false);
        dp[n - 1] = true;
        for (int i = n - 2; i >= 0; i--) {
            int temp = nums[i];
            for (int j = temp; j > 0; j--) {
                if (i + j >= n || dp[i + j]) { // 注意这里的判断条件，有可能数组越界
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[0];
    }

}
