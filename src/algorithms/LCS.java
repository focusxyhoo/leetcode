package algorithms;

import java.util.Scanner;

public class LCS {
    private String s1;
    private String s2;

    public LCS(String s1, String s2) {
        this.s1 = s1;
        this.s2 = s2;
    }

    /**
     * if only need to return the longest length, ...
     * what about return all the possible LCS? 
     * @return one of the longest common subsequence
     */
    public String getLongestCommonSubsequece() {
        int n = s1.length();
        int m = s2.length();
        int[][] table = new int[n + 1][m + 1];

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++)
                if (s1.charAt(i - 1) == s2.charAt(j - 1))
                    table[i][j] = table[i - 1][j - 1] + 1;
                else table[i][j] = Math.max(table[i - 1][j], table[i][j - 1]);
        }

        StringBuilder sb = new StringBuilder();
        int i = n, j = m;
        while (i != 0 && j != 0) {
            if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                sb.append(s1.charAt(i - 1));
                i--;
                j--;
            } else {
                if (table[i][j - 1] > table[i - 1][j]) j--;
                else i--;
            }
        }
        return sb.reverse().toString();
    }

    /**
     * what about return all the possible lcs
     * @return the longest length of lcs
     */
    public int getLongestCommonSubstring() {
        int n = s1.length();
        int m = s2.length();
        int max = 0; // record the length of the Longest substring
        int[][] table = new int[n + 1][m + 1];

        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    table[i][j] = table[i - 1][j - 1] + 1;
                    max = Math.max(table[i][j], max);
                }
                else table[i][j] = 0;
            }
        }
        return max;
    }

    public static void main(String[] agrs) {
        Scanner scanner = new Scanner(System.in);
        String s1 = scanner.nextLine();
        String s2 = scanner.nextLine();
        scanner.close();
        LCS lcs = new LCS(s1, s2);
        System.out.println("Longest Common Subsequence: " + lcs.getLongestCommonSubsequece());
    }
}