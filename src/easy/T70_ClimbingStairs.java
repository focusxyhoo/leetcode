package easy;

/**
 * created with IntelliJ IDEA
 * author      : focusxyhoo
 * date        : 2019-07-05
 * time        : 08:52
 * description :
 */
public class T70_ClimbingStairs {
    public static void main(String[] args) {

    }

    public static int climbStairs(int n) {
        if (n == 1) return 1;
        if (n == 2) return 2;
        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }
}
