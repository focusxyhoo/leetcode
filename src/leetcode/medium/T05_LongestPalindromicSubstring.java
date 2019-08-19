package leetcode.medium;

/**
 * created with IntelliJ IDEA
 * author      : focusxyhoo
 * date        : 2019-08-14
 * time        : 18:18
 * description :
 */
public class T05_LongestPalindromicSubstring {
    public static void main(String[] args) {
        System.out.println(longestPalindrome("helool"));
    }

    // brute force
    // Runtime: 954 ms, faster than 5.00% of Java online submissions for Longest Palindromic Substring.
    // Memory Usage: 37 MB, less than 96.77% of Java online submissions for Longest Palindromic Substring.
    public static String longestPalindrome(String s) {
        int n = s.length();
        if (null == s || s.length() == 0) return "";
        int maxLen = 0;
        String ans = null;
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                if (isPalindrome(s, i, j)) {
                    int temp = j - i + 1;
                    if (maxLen < temp) {
                        maxLen = temp;
                        ans = s.substring(i, j + 1);
                    }
                }
            }
        }
        return ans;
    }

    private static boolean isPalindrome(String s, int start, int end) {
        while (start < end) {
            if (s.charAt(start) != s.charAt(end)) return false;
            start++;
            end--;
        }
        return true;
    }
}
