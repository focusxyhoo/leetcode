package algorithms;

import java.util.Scanner;

/**
 * created with IntelliJ IDEA
 * author      : focusxyhoo
 * date        : 2019-08-21
 * time        : 10:50
 * description : 用字符串表示的大数之间的加减乘除。
 * 如字符串 "1234567" 代表大数 1234567。
 */
public class BigNumber {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String a = scanner.nextLine();
        String b = scanner.nextLine();

        System.out.println(add(a, b));
    }

    /**
     * 实现大数加法。
     *
     * @param s1
     * @param s2
     * @return
     */
    public static String add(String s1, String s2) {
        char[] c1 = new StringBuilder(s1).reverse().toString().toCharArray();
        char[] c2 = new StringBuilder(s2).reverse().toString().toCharArray();

        int lena = c1.length, lenb = c2.length;
        int maxLen = Math.max(lena, lenb);
        int[] result = new int[maxLen + 1]; // 加一防止进位

        for (int i = 0; i < maxLen + 1; i++) {
            int bita = i < lena ? (c1[i] - '0') : 0; // 不足位的在前面补 0
            int bitb = i < lenb ? (c2[i] - '0') : 0;
            result[i] = bita + bitb;
        }

        for (int i = 0; i < maxLen + 1; i++) {
            if (result[i] >= 10) {
                result[i + 1] += result[i] / 10;
                result[i] %= 10;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = maxLen; i >= 0; i--) {
            if (i == maxLen && result[i] == 0) continue;
            sb.append(result[i]);
        }
        return sb.toString();
    }

    /**
     * 实现大数减法。
     *
     * @param s1
     * @param s2
     * @return
     */
    public static String subtract(String s1, String s2) {
        char[] c1 = new StringBuilder(s1).reverse().toString().toCharArray();
        char[] c2 = new StringBuilder(s2).reverse().toString().toCharArray();
        // 比较哪个数更大
        int lena = c1.length, lenb = c2.length;
        int minLen = 0, maxLen = 0;
        char[] maxNumbers = null;
        if (lena < lenb) { // 先按位数多少来比较
            minLen = lena;
            maxLen = lenb;
            maxNumbers = c2;
        } else if (lena > lenb) {
            minLen = lenb;
            maxLen = lena;
            maxNumbers = c1;
        } else { // 如果位数相等，从高位开始比较每一位的大小
            maxLen = lena;
            minLen = lena;
            for (int i = lena - 1; i >= 0; i--) {
                if (c1[i] - c2[i] > 0) {
                    maxNumbers = c1;
                } else if (c1[i] - c2[i] < 0) {
                    maxNumbers = c2;
                }
            }
        }

        char[] minNumbers = maxNumbers == c1 ? c2 : c1;
        int[] result = new int[maxLen];

        return null;
    }

    /**
     * 实现大数乘法
     *
     * @param s1
     * @param s2
     * @return
     */
    public static String mutiply(String s1, String s2) {
        return null;
    }

    /**
     * 实现大数除法。
     *
     * @param s1
     * @param s2
     * @return
     */
    public static String divide(String s1, String s2) {
        return null;

    }

    /**
     * 实现大数模运算。
     *
     * @param s1
     * @param s2
     * @return
     */
    public static String mod(String s1, String s2) {
        return null;

    }
}
