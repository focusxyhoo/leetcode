package hard;

/**
 * created with IntelliJ IDEA
 * author      : focusxyhoo
 * date        : 2019-06-12
 * time        : 15:37
 * description :
 */
public class T32_LongestValidParentheses {

    public static int longestValidParentheses(String s) {

        int result = 0;
        int length = s.length();
        int[] dp = new int[length];
        for (int i = 1; i < length; i++) {
            if (s.charAt(i) == ')') {
                if (s.charAt(i - 1) == '(') {
                    dp[i] = (i >= 2 ? dp[i - 2] : 0) + 2;
                }
            }
        }
        return 1;
    }



    public static void main(String[] args) {

    }
}
