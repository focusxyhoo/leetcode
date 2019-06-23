package easy;

/**
 * created with IntelliJ IDEA
 * author      : focusxyhoo
 * date        : 2019-06-23
 * time        : 20:40
 * description :
 * Solution 1 : brute force. time : O(m*n) space : O(n)  ~235 ms
 * Solution 2 : 空间换时间
 * Solution 3 : dp           time : O(n+m) space : O(n)  ~51 ms
 */

// brute force
//public class T303_NumArray {
//
//    public static void main(String[] args) {
//
//    }
//
//    private int[] data;
//    public T303_NumArray(int[] nums) {
//        data=nums;
//    }
//
//    public int sumRange(int i, int j) {
//        int sum=0;
//        for (int k = 0; k <= i; k++) {
//            sum+=data[k];
//        }
//        return sum;
//    }
//}

// dp
public class T303_NumArray {

    private int[] dp;

    public T303_NumArray(int[] nums) {
        int n = nums.length;
        if (n==0) return;
        dp = new int[n];
        dp[0] = nums[0];
        for (int i = 1; i < n; i++) {
            dp[i] = dp[i - 1] + nums[i];
        }
    }

    int sumRange(int i, int j) {

        if (i==0) return dp[j];
        return dp[j] - dp[i - 1];
    }
}
