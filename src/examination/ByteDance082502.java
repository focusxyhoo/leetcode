package examination;

import java.util.Arrays;
import java.util.Scanner;

/**
 * created with IntelliJ IDEA
 * author      : focusxyhoo
 * date        : 2019/8/25
 * time        : 18:55
 * description :
 */
public class ByteDance082502 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
//        System.out.println(recursive(n) % 1000000007);

        long[] dp = new long[n + 1];
        dp[0] = 1;
        dp[2] = 1;
        for (int i = 4; i < n + 1; i += 2) {
            for (int j = i - 2; j >= 0; j -= 2) {
                dp[i] += dp[j] * dp[i - 2 - j];
                dp[i] %= 1000000007;
            }
        }
        System.out.println(dp[n]);
    }

    private static int recursive(int n) {
        if (n == 0) return 1;
        if (n == 2) return 1;
        int sum = 0;
        for (int i = n - 2; i >= 0; i -= 2) {
            sum += recursive(i) * recursive(n - 2 - i);
        }
        return sum;
    }
}
