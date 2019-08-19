package leetcode.easy;

import java.util.*;

/**
 * created with IntelliJ IDEA
 * author      : focusxyhoo
 * date        : 2019-08-12
 * time        : 08:44
 * description :
 */
public class T136_SingleNumber {
    public static void main(String[] args) {
        int[] nums = {1,1, 2, 2, 3, 3,4};
        System.out.println(singleNumber(nums));
    }

    /**
     * Runtime: 0 ms, faster than 100.00% of Java online submissions for Single Number.
     * Memory Usage: 38.5 MB, less than 98.52% of Java online submissions for Single Number.
     * @param nums
     * @return
     */
    public static int singleNumber(int[] nums) {
        int ans = 0;
        for (int num : nums) {
            ans ^= num;
        }
        return ans;
    }

    /**
     * Runtime: 5 ms, faster than 37.71% of Java online submissions for Single Number.
     * Memory Usage: 40.5 MB, less than 81.48% of Java online submissions for Single Number.
     * @param nums
     * @return
     */
    public static int singleNumber2(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        int setSum = 0;
        for (Integer integer : set) {
            setSum += integer;
        }
        int sum = 0;
        for (int num : nums) {
            sum+=num;
        }
        return 2 * setSum - sum;
    }


}
