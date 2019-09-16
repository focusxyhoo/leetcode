package examination;

import java.util.Arrays;

/**
 * created with IntelliJ IDEA
 * author      : focusxyhoo
 * date        : 2019/8/30
 * time        : 19:53
 * description :
 */
public class Ali {
    public static void main(String[] args) {
        int[][] area = {{1,2,3,5,7,6},
                {2,1,4,5,7,4},
                {3,4,5,6,3,6},
                {2,3,1,4,6,8},
                {5,6,1,4,6,2},
                {4,2,4,1,1,6}};
        System.out.println(get(6, area));
    }

    private static int get(int n, int[][] area) {
        int k;
        if (n % 2 == 0) k = n + 1;
        else k = n;
        int[][] dp = new int[k][n];

        for (int i = 2; i < k; i += 2) {
            for (int j = 0; j < n; j++) {
                if (j < 2) {
                    dp[i][j] = dp[i - 2][j] + area[i - 1][j];
                } else {
                    if (i != k - 1) {
                        dp[i][j] = Math.min(dp[i - 2][j] + area[i - 1][j], dp[i][j - 2] + area[i][j - 1]);
                    } else {
                        dp[i][j] = dp[i - 2][j] + area[i - 1][j];
                    }
                }
            }
        }
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++)
            min = Math.min(min, dp[k - 1][i]);
        return min;
    }
}
