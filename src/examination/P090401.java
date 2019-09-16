package examination;

import java.util.Scanner;

/**
 * created with IntelliJ IDEA
 * author      : focusxyhoo
 * date        : 2019/9/4
 * time        : 20:18
 * description :
 */
public class P090401 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        if (n >= 9) {
            int times = n / 9;
            for (int i = times; i >= 0; i--) {
                int temp = n - i * 9;
                if (isDivide4(temp)) {
                    System.out.println(i + temp / 4);
                    return;
                }
            }
            System.out.println(-1);
        } else if (n >= 4) {
            if (isDivide4(n)) {
                System.out.println(n / 4);
            } else {
                System.out.println(-1);
            }
        } else {
            System.out.println(-1);
        }
    }

    private static boolean isDivide4(int n) {
        return n % 4 == 0;
    }
}
