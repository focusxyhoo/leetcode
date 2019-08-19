package leetcode.medium;

/**
 * created with IntelliJ IDEA
 * author      : focusxyhoo
 * date        : 2019-06-24
 * time        : 11:47
 * description : https://leetcode.com/problems/unique-paths-ii/
 */
public class T63_UniquePathsII {
    public static void main(String[] args) {

    }

    /**
     * dp
     * ~1 ms
     *
     * @param obstacleGrid
     * @return
     */
    public static int uniquePathsWithObastacles(int[][] obstacleGrid) {

        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;

        int[][] dp = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (obstacleGrid[i][j] == 1) dp[i][j] = 0;
                else {
                    if (i == 0) {
                        if (j == 0) dp[i][j] = 1;
                        else dp[i][j] = dp[i][j - 1];
                    } else if (j == 0) dp[i][j] = dp[i - 1][j];
                    else dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                }

            }
        }
        return dp[m - 1][n - 1];
    }
}
