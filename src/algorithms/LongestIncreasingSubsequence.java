package algorithms;


/**
 * created with IntelliJ IDEA
 * author      : focusxyhoo
 * date        : 2019-06-25
 * time        : 16:09
 * description :
 */
public class LongestIncreasingSubsequence {

    /**
     * @param nums
     * @return
     */
    public static int lengthOfLIS(int[] nums) {
        int[] temp = new int[nums.length + 1];
        temp[0] = Integer.MIN_VALUE;
        for (int i = 1; i <= nums.length; i++) temp[i] = nums[i - 1];

        return backtrack(0, 1, temp);
    }

    /**
     * @param i
     * @param j
     * @param nums
     * @return
     */
    public static int backtrack(int i, int j, int[] nums) {

        if (j > nums.length - 1) {
            return 0;
        } else if (nums[j] <= nums[i]) {
            return backtrack(i, j + 1, nums);
        } else {
            int skip = backtrack(i, j + 1, nums);
            int take = backtrack(j, j + 1, nums) + 1;
            return Math.max(skip, take);
        }
    }

    public static void main(String[] args) {
        int[] nums = {2, 4, 5, 3, 6, 5, 7};
        System.out.println(lengthOfLIS(nums));
    }
}
