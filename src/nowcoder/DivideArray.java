package nowcoder;

import java.util.Arrays;

/**
 * created with IntelliJ IDEA
 * author      : focusxyhoo
 * date        : 2019/9/24
 * time        : 17:13
 * description : 给出一个数组，要求将其分为两部分，且其和的差值最小。
 */
public class DivideArray {

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5, 6, 7, 8};
        System.out.println(core(nums));

    }

    private static int core(int[] nums) {
        int sum = Arrays.stream(nums).sum();
        int len = nums.length;
        int halfOfSum = sum / 2;
        int[][] dp = new int[len + 1][halfOfSum + 1];

        for (int i = 0; i < dp.length; i++) {
            dp[i][0] = 0;
        }
        for (int i = 0; i < dp[0].length; i++) {
            dp[0][i] = 0;
        }

        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                dp[i][j] = dp[i - 1][j];
                if (j - nums[i - 1] >= 0 && dp[i - 1][j - nums[i - 1]] + nums[i - 1] > dp[i][j]) {
                    dp[i][j] = dp[i - 1][j - nums[i - 1]] + nums[i - 1];
                }
            }
        }
        System.out.println(dp[len][halfOfSum]);
        return sum - dp[len][halfOfSum] * 2;
    }
}
