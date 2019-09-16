package algorithms;

import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;

public class LIS {
    private int[] nums;

    public LIS(int[] nums) {
        this.nums = nums;
    }

    /**
     * 
     * @return
     */
    public String getLongestIncreasingSubsequence1() {
        int n = nums.length;
        int[] backup = Arrays.copyOf(nums, n);
        Arrays.sort(nums);
        LCS lcs = new LCS(convert(nums), convert(backup));
        return lcs.getLongestCommonSubsequece();
    }

    private String convert(int[] nums) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < nums.length; i++) {
            sb.append(nums[i]);
        }
        return sb.toString();
    }

    /**
     * dp
     * time: O(n^2)
     * @return
     */
    public int getLongestIncreasingSubsequence2() {
        int n = nums.length;
        int[] dp = new int[n];
        int max = 0;
        Arrays.fill(dp, 1);
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            max = Math.max(max, dp[i]);
        }
        return max;
    }

    /**
     * 
     * @return
     */
    public int getLongestIncreasingSubsequence3() {
        int n = nums.length;
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (list.isEmpty() || list.get(list.size() - 1) < nums[i])
                list.add(nums[i]);
            else {
                int low = 0, high = list.size() - 1;
                while (low < high) {
                    int mid = (low + high) / 2;
                    if (list.get(mid) < nums[i]) low = mid + 1;
                    else high = mid - 1;
                }
                list.remove(low);
                list.add(low, nums[i]);
            }
        }
        return list.size();
    }

    public static void main(String[] agrs) {
        int[] nums = new int[]{3, 5, 7, 1, 2, 8};
        LIS lis = new LIS(nums);
        System.out.println(lis.getLongestIncreasingSubsequence3());
    }
}