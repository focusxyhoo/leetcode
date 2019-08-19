package leetcode.hard;

import java.util.LinkedList;
import java.util.Stack;

/**
 * created with IntelliJ IDEA
 * author      : focusxyhoo
 * date        : 2019-06-12
 * time        : 15:37
 * description : 最长合法括号。
 */
public class T32_LongestValidParentheses {

    /**
     * dp
     * time : O(n)  space : O(n)
     * 我们用dp[i]来表示前i个字符组成的字符串的合法括号长度。初始化dp[i]=0
     * ~2 ms
     *
     * @param s
     * @return
     */
    public static int longestValidParentheses(String s) {

        int result = 0;
        int length = s.length();
        int[] dp = new int[length];
        for (int i = 1; i < length; i++) {
            if (s.charAt(i) == ')') {
                if (s.charAt(i - 1) == '(') {
                    dp[i] = (i >= 2 ? dp[i - 2] : 0) + 2;
                } else if (i - dp[i - 1] > 0 && s.charAt(i - dp[i - 1] - 1) == '(') {
                    dp[i] = dp[i - 1] + ((i - dp[i - 1]) >= 2 ? dp[i - dp[i - 1] - 2] : 0) + 2;
                }
                result = Math.max(result, dp[i]);
            }
        }
        return result;
    }

    /**
     * use stack
     * time : O(n)  space : O(n)
     * ~6 ms
     *
     * @param s
     * @return
     */
    public static int longestValidParentheses2(String s) {

        int result = 0;
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else {
                stack.pop();
                if (stack.empty()) {
                    stack.push(i);
                } else {
                    result = Math.max(result, i - stack.peek());
                }
            }
        }
        return result;
    }


    public static void main(String[] args) {

        String str = "(((())";
        System.out.println(longestValidParentheses(str));
        System.out.println(longestValidParentheses2(str));


    }
}
