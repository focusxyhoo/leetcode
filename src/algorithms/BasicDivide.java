package algorithms;

import java.util.Scanner;

/**
 * created with IntelliJ IDEA
 * author      : focusxyhoo
 * date        : 2019-08-09
 * time        : 22:28
 * description :
 */
public class BasicDivide {
    public static void main(String[] args) {
        while (true) {
            Scanner scanner = new Scanner(System.in);
            int m = scanner.nextInt();
            int n = scanner.nextInt();

            StringBuilder sb = new StringBuilder();

            int count = 8;
            while (true) {
                if (count <= 0) break;
                int temp = m % n;
                int ans = m / n;
                if (count == 1) {
                    if (ans >= 5) {
                        int prev = sb.charAt(sb.length() - 1) - '0';
//                        System.out.println(prev);
                        sb = new StringBuilder(sb.substring(0, sb.length() - 1));
                        sb.append(prev + 1);
                    }
                } else {
                    sb.append(ans);
                }
                if (count == 8) sb.append(".");
                temp *= 10;
                m = temp;
                count--;
//                System.out.println(sb.toString());
            }
            System.out.println(sb.toString());

        }

    }
}
