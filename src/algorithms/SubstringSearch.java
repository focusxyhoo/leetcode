package algorithms;

import java.util.*;

public class SubstringSearch {

    /**
     * brute force in substring search
     * @param s
     * @param pattern
     * @return the first index matches, or return n to indicate a mismatch
     */
    public static int search(String s, String pattern) {
        int n = s.length();
        int m = pattern.length();
        for (int i = 0; i <= n - m; i++) {
            int j;
            for (j = 0; j < m; j++) {
                if (s.charAt(i + j) != pattern.charAt(j)) break;
            }
            if (j == m) return i;
        }
        return n; // failed
    }

    /**
     * another implement of the search method
     * @param s
     * @param pattern
     * @return
     */
    public static int search2(String s, String pattern) {
        int n = s.length();
        int m = pattern.length();
        int i, j;
        for (i = 0, j = 0; i < n && j < m; i++) {
            if (s.charAt(i) == pattern.charAt(j)) j++;
            else {
                i -= j;
                j = 0;
            }
        }
        if (j == m) return i - m;
        else return n;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        String pattern = scanner.nextLine();
        scanner.close();

        int offset = SubstringSearch.search2(s, pattern);
        System.out.println(offset);
        System.out.println("text:    " + s);
        System.out.print("pattern: ");
        for (int i = 0; i < offset; i++) {
            System.out.print(" ");
        }
        System.out.println(pattern);
    }
}