package easy;

/**
 * created with IntelliJ IDEA
 * author      : focusxyhoo
 * date        : 2019-07-09
 * time        : 14:57
 * description :
 */
public class T303_RangeSumQueryImmutable {

    static class NumArray {

        private int[] dp;

        public NumArray(int[] nums) {
            int n = nums.length;
            if (n == 0) return;
            dp = new int[n];
            dp[0] = nums[0];
            for (int i = 1; i < n; i++)
                dp[i] = dp[i - 1] + nums[i];
        }

        public int sumRange(int i, int j) {
            if (i == 0) return dp[j];
            return dp[j] - dp[i - 1];
        }
    }

    public static void main(String[] args) {
        int[] temp = {1, 2, 3, 4};
        NumArray numArray = new NumArray(temp);
        System.out.println(numArray.sumRange(0, 1));
    }
}
