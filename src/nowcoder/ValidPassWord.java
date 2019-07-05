package nowcoder;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * created with IntelliJ IDEA
 * author      : focusxyhoo
 * date        : 2019-07-04
 * time        : 15:14
 * description :
 */
public class ValidPassWord {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (scanner.hasNext()) {
            String passwd = scanner.nextLine();
            if (isValidPasswd(passwd)) System.out.println("OK");
            else System.out.println("NG");
        }
    }


    private static boolean isValidPasswd(String s) {
        if (s == null || s.length() <= 8) return false;
        else {
            int[] flag = new int[4];
            for (int i = 0; i < s.length(); i++) {
                char ch = s.charAt(i);
                if (ch >= '0' && ch <= '9') flag[0] = 1;
                else if (ch >= 'a' && ch <= 'z') flag[1] = 1;
                else if (ch >= 'A' && ch <= 'Z') flag[2] = 1;
                else flag[3] = 1;
            }
            if (flag[0] + flag[1] + flag[2] + flag[3] < 3) return false;
            else return validSubstring(s);
        }
    }

    private static boolean validSubstring(String s) {
        for (int i = 0; i <= s.length() - 3; i++) {
            String temp = s.substring(i, i + 3);
            String left = s.substring(i+1);
            if (left.contains(temp)) return false;
        }
        return true;
    }


}
