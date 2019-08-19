package leetcode.medium;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * created with IntelliJ IDEA
 * author      : focusxyhoo
 * date        : 2019-08-14
 * time        : 17:26
 * description : https://leetcode.com/problems/longest-substring-without-repeating-characters
 * need to be further study
 */
public class T03_LongestSubstringWithoutRepeat {
    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring2("abccde"));
    }

    // brute force
    // find all substring and judge it whether it's unique
    // time O(n^3)
    public static int lengthOfLongestSubstring(String s) {
        int n = s.length();
        int ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j <= n; j++) {
                if (isAllUnique(s, i, j)) ans = Math.max(ans, j - i);
            }
        }
        return ans;
    }

    private static boolean isAllUnique(String s, int start, int end) {
        Set<Character> set = new HashSet<>();
        for (int i = start; i < end; i++) {
            if (!set.add(s.charAt(i))) return false;
        }
        return true;
    }

    // sliding window
    // Runtime: 8 ms, faster than 65.19% of Java online submissions for Longest Substring Without Repeating Characters.
    // Memory Usage: 37.1 MB, less than 99.76% of Java online submissions for Longest Substring Without Repeating Characters.
    public static int lengthOfLongestSubstring2(String s) {
        int n = s.length();
        int ans = 0;
        Set<Character> set = new HashSet<>();
        int i = 0, j = 0;
        while (i < n && j < n) { // try to extend the range [i, j]
            if (set.add(s.charAt(j))) { // if set not contains s.charAt(j), add() return true
                j++;
                ans = Math.max(ans, j - i);
            } else { // set already contains s.charAt(j), increase i
                set.remove(s.charAt(i++));
            }
        }
        return ans;
    }

    // optimized sliding window

    public static int lengthOfLongestSubstring3(String s) {
        int n = s.length();
        int ans = 0;
        Map<Character, Integer> map = new HashMap<>(); // record character and according index
        for (int i = 0, j = 0; j < n; j++) {
            if (map.containsKey(s.charAt(j))) {
                i = Math.max(map.get(s.charAt(j)), i);
            }
            ans = Math.max(ans, j - i + 1);
            map.put(s.charAt(j), j + 1);
        }
        return ans;
    }
}
