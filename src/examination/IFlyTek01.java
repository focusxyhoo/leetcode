package examination;

import java.util.Arrays;
import java.util.Scanner;

/**
 * created with IntelliJ IDEA
 * author      : focusxyhoo
 * date        : 2019/9/12
 * time        : 09:59
 * description :
 */
public class IFlyTek01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        String[] temp = s.split(" ");
        String one = temp[0];
        String two = temp[temp.length - 1];
        System.out.println(add(one, two));
    }

    private static String add(String s1, String s2) {
//        int maxLen = Math.max(one.length(), two.length());
//        int[] result = new int[maxLen + 1];
//        int flag = 0;
//        int i = one.length() - 1, j = two.length() - 1, index = 0;
//        while (i >= 0 && j >= 0) {
//            result[index] = (one.charAt(i) - '0') + (two.charAt(j) - '0') + flag;
////            System.out.println("result[" + i + "]:" + result[i]);
//            flag = result[index] / 10;
//            result[index] %= 10;
//            i--;
//            j--;
//            index++;
//        }
//        while (i >= 0) {
//            result[index] = flag + (one.charAt(i) - '0');
//            flag = result[index] / 10;
//            result[index] %= 10;
//            i--;
//            index++;
//        }
//        while (j >= 0) {
//            result[index] = flag + (two.charAt(j) - '0');
//            flag = result[index] / 10;
//            result[index] %= 10;
//            j--;
//            index++;
//        }
//        if (flag != 0) result[index] = flag;
//        StringBuilder ans = new StringBuilder();
//        for (int k = result.length - 1; k >= 0; k--) {
//            if (k == result.length - 1 && result[k] == 0) continue;
//            ans.append(result[k]);
//        }
//        System.out.println(ans.toString());

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

}
