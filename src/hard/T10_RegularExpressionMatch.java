package hard;

/**
 * created with IntelliJ IDEA
 * author      : focusxyhoo
 * date        : 2019-06-10
 * time        : 16:25
 * description : 简单正则表达式的匹配。
 */

enum Result {
    TRUE, FALSE
}

public class T10_RegularExpressionMatch {
    public static void main(String[] args) {
        String s = "aabc";
        String p = ".*";
        System.out.println(isMatchDP(s, p));
    }

    /**
     * created by monkeyGoCrazy:
     * This Solution use 2D DP. beat 90% solutions, very simple.
     *
     * @param s
     * @param p
     * @return
     */
    public static boolean isMatch(String s, String p) {
        if (s == null || p == null) {
            return false;
        }
        boolean[][] dp = new boolean[s.length() + 1][p.length() + 1];
        dp[0][0] = true;
        for (int i = 0; i < p.length(); i++) {
            if (p.charAt(i) == '*' && dp[0][i - 1]) {
                dp[0][i + 1] = true;
            }
        }
        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j < p.length(); j++) {
                if (p.charAt(j) == '.') {
                    dp[i + 1][j + 1] = dp[i][j];
                }
                if (p.charAt(j) == s.charAt(i)) {
                    dp[i + 1][j + 1] = dp[i][j];
                }
                if (p.charAt(j) == '*') {
                    if (p.charAt(j - 1) != s.charAt(i) && p.charAt(j - 1) != '.') {
                        dp[i + 1][j + 1] = dp[i + 1][j - 1];
                    } else {
                        dp[i + 1][j + 1] = (dp[i + 1][j] || dp[i][j + 1] || dp[i + 1][j - 1]);
                    }
                }
            }
        }
        return dp[s.length()][p.length()];
    }

    /**
     * 递归思想解决问题。
     *
     * @param text
     * @param pattern
     * @return
     */
    public static boolean isMatchRecursively(String text, String pattern) {
        if (pattern.isEmpty()) return text.isEmpty();
        boolean firstMatch = (!text.isEmpty() && (pattern.charAt(0) == text.charAt(0) || pattern.charAt(0) == '.'));

        if (pattern.length() >= 2 && pattern.charAt(1) == '*') {
            return (isMatchRecursively(text, pattern.substring(2)) ||
                    (firstMatch && isMatchRecursively(text.substring(1), pattern)));
        } else {
            return firstMatch && isMatchRecursively(text.substring(1), pattern.substring(1));
        }
    }

    static Result[][] memo;

    /**
     * 动态规划。
     * Top-Down Variation
     *
     * @param text
     * @param pattern
     * @return
     */
    public static boolean isMatchDP(String text, String pattern) {
        memo = new Result[text.length() + 1][pattern.length() + 1];
        return dp(0, 0, text, pattern);
    }

    public static boolean dp(int i, int j, String text, String pattern) {
        if (memo[i][j] != null) {
            return memo[i][j] == Result.TRUE;
        }
        boolean ans;
        if (j == pattern.length()) {
            ans = i == text.length();
        } else {
            boolean firstMatch = (i < text.length() &&
                    (pattern.charAt(j) == text.charAt(i) || pattern.charAt(j) == '.'));
            if (j + 1 < pattern.length() && pattern.charAt(j + 1) == '*') {
                ans = (dp(i, j + 2, text, pattern) || firstMatch && dp(i + 1, j, text, pattern));
            } else {
                ans = firstMatch && dp(i + 1, j + 1, text, pattern);
            }
        }
        memo[i][j] = ans ? Result.TRUE : Result.FALSE;
        return ans;
    }
}
