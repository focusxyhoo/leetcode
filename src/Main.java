import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int[] price = new int[m + 1];
        int[] value = new int[m + 1];
        int[] tag = new int[m + 1];
        for (int i = 1; i <= m; i++) {
            price[i] = in.nextInt();
            value[i] = in.nextInt() * price[i];
            tag[i] = in.nextInt();
        }
        int[][] dp = new int[m + 1][n + 1];

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (tag[i] == 0) {
                    if (price[i] <= j) {
                        dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - price[i]] + value[i]);
                    }
                } else {
                    if (price[i] + price[tag[i]] <= j) {
                        dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - price[i] - price[tag[i]]] + value[i] + value[tag[i]]);
                    }
                }
            }
        }
        System.out.println(dp[m][n]);
    }
}