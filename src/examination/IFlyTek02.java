package examination;

import java.util.Scanner;

/**
 * created with IntelliJ IDEA
 * author      : focusxyhoo
 * date        : 2019/9/12
 * time        : 10:38
 * description :
 */
public class IFlyTek02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();

        StringBuilder sb = new StringBuilder();
        char prev = s.charAt(0);
        int count = 1;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == prev) {
                count++;
            } else {
                if (count != 1) {
                    sb.append(count);
                }
                sb.append(prev);
                prev = s.charAt(i);
                count = 1;
            }
        }
        if (count != 1) {
            sb.append(count);
        }
        sb.append(prev);

        System.out.println(sb.toString());
    }
}
