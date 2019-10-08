package examination;

import java.util.Scanner;

/**
 * created with IntelliJ IDEA
 * author      : focusxyhoo
 * date        : 2019/9/21
 * time        : 15:56
 * description :
 */
public class Netease04 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
        }
        int[] dp = new int[n];
        int[] max = new int[n];
        dp[0] = 0;
        max[0] = nums[0];

        for (int i = 1; i < n; i++) {
            if (nums[i] >= max[i - 1]) {
                dp[i] = dp[i - 1];
                max[i] = nums[i];
            } else {
                max[i] = max[i - 1];
                dp[i] = dp[i - 1];
                for (int j = 0; j < i; j++) {
                    if (nums[j] > nums[i]) {
                        dp[i] += (i - j);
                    }
                }
            }
        }

        System.out.println(dp[n - 1]);
    }
}
