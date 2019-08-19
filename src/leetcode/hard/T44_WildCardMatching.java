package leetcode.hard;

import java.util.Arrays;

/**
 * created with IntelliJ IDEA
 * author      : focusxyhoo
 * date        : 2019-06-24
 * time        : 10:46
 * description : https://leetcode.com/problems/wildcard-matching/
 */
public class T44_WildCardMatching {
    public static void main(String[] args) {
        System.out.println(isMatch("aa", "a"));

    }

    /**
     * dp
     * three conditions:
     * 1. p.charAt(j) == '*' : dp[i+1][j+1] = dp[i][j] || dp[i+1][j] || dp[i][j+1]
     * 2. p.charAt(j) == '?' || p.charAt(j) == s.charAt(i) : dp[i+1][j+1] = dp[i][j]
     * 3. p.charAt(j) != s.charAt(i) : dp[i+1][j+1] = false;
     * ~13 ms
     *
     * @param s
     * @param p
     * @return
     */
    public static boolean isMatch(String s, String p) {
        int m = s.length();
        int n = p.length();

        // initialize the dp array
        boolean[][] dp = new boolean[m + 1][n + 1];
        dp[0][0] = true;
        for (int i = 1; i <= n; i++) {
            if (p.charAt(i - 1) == '*') {
                dp[0][i] = dp[0][i - 1];
            } else {
                dp[0][i] = false;
            }

        }
        for (int i = 1; i <= m; i++) dp[i][0] = false;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (p.charAt(j) == '*') {
                    dp[i + 1][j + 1] = dp[i][j] || dp[i][j + 1] || dp[i + 1][j];
                } else if (p.charAt(j) == '?' || p.charAt(j) == s.charAt(i)) {
                    dp[i + 1][j + 1] = dp[i][j];
                } else if (p.charAt(j) != s.charAt(i)) {
                    dp[i + 1][j + 1] = false;
                }
            }
        }
        return dp[m][n];
    }
}

