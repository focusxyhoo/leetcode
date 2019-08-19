package examination;

import java.util.Scanner;

/**
 * created with IntelliJ IDEA
 * author      : focusxyhoo
 * date        : 2019-08-14
 * time        : 18:24
 * description : 华为笔试第一题
 */
public class Huawei01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        String s = getBits(n);
        int len = s.length();
        int count = 0, index = -1;
        boolean isFirst = true;
        for (int i = 0; i < len - 2; ) {
            if (s.substring(i, i + 3).equals("101")) {
                count++;
                if (isFirst) {
                    index = i;
                    isFirst = false;
                }
                i += 2;
            } else i++;
        }
        System.out.println(count + " " + index);
    }

    private static String getBits(int n) {
        StringBuilder sb = new StringBuilder();
        while (n > 0) {
            sb.append(n % 2);
            n >>= 1;
        }
        return sb.toString();
    }
}
