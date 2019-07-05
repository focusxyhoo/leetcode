package nowcoder;

import java.util.Scanner;

/**
 * created with IntelliJ IDEA
 * author      : focusxyhoo
 * date        : 2019-07-04
 * time        : 16:15
 * description :
 */
public class SimplePasswd {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String s = scanner.nextLine();
            System.out.println(convert(s));

        }
    }

    private static String convert(String s) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch >= 'A' && ch <= 'Z') {
                ch = Character.toLowerCase(ch);
                if (ch == 'z') ch = 'a';
                else
                    ch = (char) (ch + 1);
            } else if (ch >= 'a' && ch <= 'z') {
                if (ch <= 'c') ch = '2';
                else if (ch <= 'f') ch = '3';
                else if (ch <= 'i') ch = '4';
                else if (ch <= 'l') ch = '5';
                else if (ch <= 'o') ch = '6';
                else if (ch <= 's') ch = '7';
                else if (ch <= 'v') ch = '8';
                else if (ch <= 'z') ch = '9';
            }
            sb.append(ch);
        }
        return sb.toString();
    }
}
