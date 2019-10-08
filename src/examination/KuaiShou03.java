package examination;

import java.util.Arrays;
import java.util.Scanner;

/**
 * created with IntelliJ IDEA
 * author      : focusxyhoo
 * date        : 2019/9/16
 * time        : 21:45
 * description : pass rate 0.6
 */
public class KuaiShou03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
        }
        Arrays.sort(nums);
        int[] dp = new int[n];
        dp[0] = 1;
        dp[1] = 2;
        int maxLength = 2;
        int diffPrev = nums[1] - nums[0];
        for (int i = 2; i < n; i++) {
            int diffCurr = nums[i] - nums[i - 1];
            if (diffCurr == diffPrev) {
                dp[i] = dp[i - 1] + 1;
            } else {
                diffPrev = diffCurr;
                dp[i] = 2;
            }
            maxLength = Math.max(maxLength, dp[i]);
        }
        System.out.println(maxLength);
    }
}
