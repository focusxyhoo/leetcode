package examination;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * created with IntelliJ IDEA
 * author      : focusxyhoo
 * date        : 2019/9/21
 * time        : 15:19
 * description :
 */
public class Netease01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
        }
        for (int i = 0; i < n; i++) {
            int[] dp = new int[nums[i]];
            if (nums[i] < 10) {
                System.out.println(nums[i]);
                continue;
            }
            for (int j = 0; j < 10; j++) {
                dp[j] = j;
            }
            for (int j = 10; j < nums[i]; j++) {
                
            }

        }

    }

    private static List<Integer> core(int num) {
        List<Integer> ans = new ArrayList<>();
        if (num < 10 && num >= 0) {
            ans.add(num);
        } else {

        }
        return ans;
    }

    private static void parse(int num, List<Integer> ans, int len) {
        for (int i = 1; i<= 9; i++) {
            ans.add(i);
            int left = num - i;
            if (num < 10 && num > 0) {
                ans.add(left);
                return;
            }
            ans.remove(ans.size() - 1);
        }
    }
}
