package examination;

import java.util.Scanner;

/**
 * created with IntelliJ IDEA
 * author      : focusxyhoo
 * date        : 2019/9/9
 * time        : 20:21
 * description :
 */
public class MEGVII01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        System.out.println(getBitOne(n));

    }

    private static int getBitOne(int n) {
        int count = 0;
        while (n > 0) {
            int temp = n ^ 1;
            if (temp % 2 == 0) count++;
            n >>= 1;
        }
        return count;
    }
}
