package examination;

import java.util.*;

/**
 * created with IntelliJ IDEA
 * author      : focusxyhoo
 * date        : 2019-08-14
 * time        : 18:55
 * description :
 */
public class Huawei03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        for (int i = 0; i < t; i++) {
            int m = scanner.nextInt();
            int[][] friend = new int[m][m];
            int userID = scanner.nextInt();
            int n = scanner.nextInt();
            int k = scanner.nextInt();
            for (int j = 0; j < k; j++) {
                int a = scanner.nextInt();
                int b = scanner.nextInt();
                int c = scanner.nextInt();
                friend[a][b] = c;
                friend[b][a] = c;
            }
            Map<Integer, Integer> ans = solve(friend, userID, n);

        }
    }

    private static Map<Integer, Integer> solve(int[][] nums, int userID, int n) {
        Map<Integer, Integer> ans = new HashMap<>();

        for (int i = 0; i <= nums.length; i++) {
            if (nums[userID][i] != 0) continue;

        }
        return null;
    }

}
