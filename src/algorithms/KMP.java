package algorithms;

import java.util.*;

public class KMP {
    private String pattern;

    public KMP(String pattern) {
        this.pattern = pattern;
    }

    /**
     * partial match table
     * @return
     */
    private int[] getNext() {
        int[] next = new int[pattern.length()];
        int k = -1;
        int j = 0;
        next[0] = -1;
        while (j < pattern.length() - 1) {
            if (k == -1 || pattern.charAt(j) == pattern.charAt(k)) {
                k++;
                j++;
                next[j] = k;
            } else k = next[k];
        }
        return next;
    }

    public int search(String s) {
        int i = 0, j = 0;
        int n = s.length();
        int m = pattern.length();
        int[] next = getNext();

        while (i < n && j < m) {
            if (j == -1 || s.charAt(i) == pattern.charAt(j)) {
                i++;
                j++;
            } else j = next[j];
        }

        if (j == m) return i - m;
        else return n;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        String pattern = scanner.nextLine();
        scanner.close();

        KMP kmp = new KMP(pattern);
        int offset = kmp.search(s);
        System.out.println("text:    " + s);
        System.out.print("pattern: ");
        for (int i = 0; i < offset; i++) {
            System.out.print(" ");
        }
        System.out.println(pattern);
    }
}