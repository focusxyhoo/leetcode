package medium;

/**
 * created with IntelliJ IDEA
 * author      : focusxyhoo
 * date        : 2019-06-24
 * time        : 11:39
 * description : https://leetcode.com/problems/unique-paths/
 */
public class T62_UniquePaths {

    public static void main(String[] args) {

        System.out.println(uniquePaths(7, 3));

    }

    /**
     * dp
     * ~0 ms
     *
     * @param m
     * @param n
     * @return
     */
    public static int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];

        // initialize the dp array
        for (int i = 0; i < m; i++) dp[i][0] = 1;
        for (int i = 0; i < n; i++) dp[0][i] = 1;

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i][j - 1] + dp[i - 1][j];
            }
        }
        return dp[m - 1][n - 1];
    }
}
