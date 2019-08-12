package practice;

/**
 * created with IntelliJ IDEA
 * author      : focusxyhoo
 * date        : 2019-08-11
 * time        : 21:05
 * description :
 */
public class CutRope {

    public static void main(String[] args) {
        int[] prices = {0, 1, 5, 8, 9, 10, 17, 17, 20, 24, 30};

        for (int i = 0; i <= 10; i++) {
            System.out.println(buttomUpCutRope(prices, i));
        }
    }

    /**
     *
     * @param priceList
     * @param n
     * @return
     */
    public static int buttomUpCutRope(int[] priceList, int n) {
        int[] dp = new int[n + 1];
        dp[0] = 0;
        for (int i = 1; i <= n; i++) {
            int temp = -1;
            for (int j = 1; j <= i; j++) {
                temp = Math.max(temp, priceList[j] + dp[i - j]);
            }
            dp[i] = temp;
        }
        return dp[n];
    }
}
