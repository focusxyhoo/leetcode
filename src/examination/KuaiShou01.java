package examination;

import java.util.Arrays;
import java.util.Scanner;

/**
 * created with IntelliJ IDEA
 * author      : focusxyhoo
 * date        : 2019/9/16
 * time        : 20:57
 * description : 0.80 pass rate
 */
public class KuaiShou01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        if (s.contains(".")) {
            String[] ipv4 = s.split("\\.");
            if (ipv4.length != 4) System.out.println("Neither");
            else {
                for (int i = 0; i < 4; i++) {
                    if (ipv4[i].charAt(0) == '0') {
                        System.out.println("Neither");
                        return;
                    } else {
                        try {
                            int curr = Integer.parseInt(ipv4[i]);
                            if (curr < 0 || curr > 255) {
                                System.out.println("Neither");
                                return;
                            }
                        } catch (NumberFormatException e) {
                            System.out.println("Neither");
                            return;
                        }
                    }
                }
                System.out.println("IPv4");
            }
        } else {
            String[] ipv6 = s.split(":");
            for (int i = 0; i < ipv6.length; i++) {
                if (!isIPv6(ipv6[i])) {
                    System.out.println("Neither");
                    return;
                }
            }
            System.out.println("IPv6");
        }
    }

    private static boolean isIPv6(String text) {
        if (text == null || text.length() == 0) return false;
        for (int i = 0; i < text.length(); i++) {
            char temp = text.charAt(i);
            if (Character.isDigit(temp)) {}
            else {
                char lower = Character.toLowerCase(temp);
                if (lower - 'a' < 0 || lower - 'a' > 6) return false;
            }
        }
        return true;
    }
}
