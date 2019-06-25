package medium;

/**
 * created with IntelliJ IDEA
 * author      : focusxyhoo
 * date        : 2019-06-24
 * time        : 12:05
 * description :
 */
public class T64_MinimumPathSum {
    public static void main(String[] args) {

    }

    /**
     * dp
     * ~3 ms
     *
     * @param grid
     * @return
     */
    public static int minPathSum(int[][] grid) {

        int m = grid.length;
        int n = grid[0].length;

        int[][] dp = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0) {
                    if (j == 0) dp[i][j] = grid[i][j];
                    else dp[i][j] = grid[i][j] + dp[i][j - 1];
                } else if (j == 0) {
                    dp[i][j] = grid[i][j] + dp[i - 1][j];
                } else dp[i][j] = grid[i][j] + Math.min(dp[i - 1][j], dp[i][j - 1]);
            }
        }
        return dp[m - 1][n - 1];
    }
}
