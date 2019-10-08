package examination;

import java.util.Scanner;

/**
 * created with IntelliJ IDEA
 * author      : focusxyhoo
 * date        : 2019/9/20
 * time        : 20:00
 * description :
 */
public class Tecent092001 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        int[] lens = new int[t];
        String[] data = new String[t];
        for (int i = 0; i < t; i++) {
            lens[i] = scanner.nextInt();
            data[i] = scanner.next();
        }
        for (int i = 0; i < t; i++) {
            if (isPhoneNumber(lens[i], data[i])) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }

    private static boolean isPhoneNumber(int len, String s) {
        if (len < 11) {
            return false;
        } else {
            for (int i = 0; i <= len - 11; i++) {
                if (s.charAt(i) == '8') {
                    return true;
                }
            }
            return false;
        }
    }
}
