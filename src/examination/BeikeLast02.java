package examination;

import java.util.Scanner;

/**
 * created with IntelliJ IDEA
 * author      : focusxyhoo
 * date        : 2019/8/23
 * time        : 19:11
 * description :
 */
public class BeikeLast02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        String s = scanner.next();

        int index = findFromEnd(s);
//        System.out.println(index);
        System.out.println(buildString(s, k, index));
    }

    private static int findFromEnd(String s) {
        int index = 0;
        for (int i = 0; i < s.length(); i++) {
            if (core(s, i)) index = i;
        }
        return index;
    }

    private static boolean core(String s, int i) {
        return s.substring(0, i).equals(s.substring(s.length() - i));
    }

    private static String buildString(String s, int count, int index) {
        StringBuilder sb = new StringBuilder(s);
        int n = count - 1;
        while (n > 0) {
//            System.out.println(s.substring(index));
            sb.append(s.substring(index));
            n--;
        }
        return sb.toString();
    }
}
