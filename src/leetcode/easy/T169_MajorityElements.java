package leetcode.easy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * created with IntelliJ IDEA
 * author      : focusxyhoo
 * date        : 2019-07-06
 * time        : 20:40
 * description :
 */
public class T169_MajorityElements {
    public static void main(String[] args) {

    }

    /**
     * sorting
     * Runtime: 1 ms
     * Memory Usage: 41.3 MB
     *
     * @param nums
     * @return
     */
    public static int majorityElement(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length / 2];

    }


    /**
     * HashMap
     * Runtime: 14 ms, faster than 18.91% of Java online submissions for Majority Element.
     * Memory Usage: 39.6 MB, less than 99.21% of Java online submissions for Majority Element.
     *
     * @param nums
     * @return
     */
    public static int majorityElement2(int[] nums) {
        Map<Integer, Integer> counts = countNums(nums);
        Map.Entry<Integer, Integer> majorityEntry = null;
        for (Map.Entry<Integer, Integer> entry : counts.entrySet()) {
            if (majorityEntry == null || entry.getValue() > majorityEntry.getValue())
                majorityEntry = entry;
        }
        return majorityEntry.getKey();
    }

    private static Map<Integer, Integer> countNums(int[] nums) {
        Map<Integer, Integer> counts = new HashMap<>();
        int n = nums.length;
        for (int num : nums) {
            if (!counts.containsKey(num)) counts.put(num, 1);
            else counts.put(num, counts.get(num) + 1);
        }
        return counts;
    }


    /**
     * Randomization 随机性较大
     * Runtime: 1 ms, faster than 100.00% of Java online submissions for Majority Element.
     * Memory Usage: 42.2 MB, less than 62.11% of Java online submissions for Majority Element.
     * Runtime: 2 ms, faster than 53.85% of Java online submissions for Majority Element.
     * Memory Usage: 42 MB, less than 63.08% of Java online submissions for Majority Element.
     *
     * @param nums
     * @return
     */
    public static int majorityElement3(int[] nums) {
        Random random = new Random();
        int majorityCount = nums.length / 2;

        while (true) {
            int temp = nums[random.nextInt(nums.length)];
            int count = 0;
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] == temp) count++;
            }
            if (count > majorityCount) return temp;
        }
    }


    /**
     * divide and conquer
     * Runtime: 1 ms, faster than 100.00% of Java online submissions for Majority Element.
     * Memory Usage: 40.5 MB, less than 98.67% of Java online submissions for Majority Element.
     *
     * @param nums
     * @return
     */
    public static int majorityElement4(int[] nums) {
        return majorityElementRec(nums, 0, nums.length - 1);
    }

    private static int majorityElementRec(int[] nums, int lo, int hi) {
        // base
        if (lo == hi) return nums[lo];

        int mid = (lo + hi) / 2;
        int left = majorityElementRec(nums, lo, mid);
        int right = majorityElementRec(nums, mid + 1, hi);

        if (left == right) return left;

        int leftCount = countRange(nums, left, lo, hi);
        int rightCount = countRange(nums, right, lo, hi);

        return leftCount > rightCount ? left : right;


    }

    private static int countRange(int[] nums, int num, int lo, int hi) {
        int count = 0;
        for (int i = lo; i <= hi; i++) {
            if (nums[i] == num) count++;
        }
        return count;
    }
}
