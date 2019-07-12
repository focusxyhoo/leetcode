package easy;

/**
 * created with IntelliJ IDEA
 * author      : focusxyhoo
 * date        : 2019-06-21
 * time        : 11:44
 * description : https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
 */
public class T121_BestTimeBuySellStock {

    public static void main(String[] args) {

        int[] nums = {7, 6, 4, 3, 1};
        System.out.println(maxProfit(nums));
    }

    /**
     * brute force
     * Runtime: 316 ms, faster than 5.02% of Java online submissions for Best Time to Buy and Sell Stock.
     * Memory Usage: 37.6 MB, less than 99.11% of Java online submissions for Best Time to Buy and Sell Stock.
     *
     * @param prices
     * @return
     */
    public static int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) return 0;

        int maxProfit = 0;
        int profit;
        for (int i = 0; i < prices.length - 1; i++) {
            int buy = prices[i];
            for (int j = i + 1; j < prices.length; j++) {
                profit = prices[j] - buy;
                if (profit >= 0) {
                    maxProfit = maxProfit >= profit ? maxProfit : profit;
                }
            }
        }
        return maxProfit;
    }

    /**
     * dp
     * Runtime: 1 ms, faster than 88.01% of Java online submissions for Best Time to Buy and Sell Stock.
     * Memory Usage: 37.7 MB, less than 98.60% of Java online submissions for Best Time to Buy and Sell Stock.
     *
     * @param prices
     * @return
     */
    public static int maxProfit2(int[] prices) {
        if (prices == null || prices.length == 0) return 0;

        int[] dp = new int[prices.length];
        dp[0] = prices[0];
        int maxProfit = 0;
        int profit;
        for (int i = 1; i < prices.length; i++) {
            dp[i] = dp[i - 1] < prices[i] ? dp[i - 1] : prices[i];
            profit = prices[i] - dp[i - 1];
            maxProfit = maxProfit > profit ? maxProfit : profit;
        }
        return maxProfit;
    }
}
