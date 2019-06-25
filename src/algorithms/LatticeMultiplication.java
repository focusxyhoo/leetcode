package others;

import java.util.Arrays;

/**
 * created with IntelliJ IDEA
 * author      : focusxyhoo
 * date        : 2019-06-24
 * time        : 09:04
 * description : 格子算法。
 * 439 * 413 = 181307
 */
public class LatticeMultiplication {

    public static void main(String[] args) {
        int[] nums1 = {9, 3, 4};
        int[] nums2 = {3, 1, 4};
        System.out.println(Arrays.toString(fibonacciMultipy(nums1, nums2)));

    }

    public static int[] fibonacciMultipy(int[] nums1, int[] nums2) {

        int hold = 0;
        int m = nums1.length, n = nums2.length;
        int[] result = new int[m + n];
        for (int k = 0; k < m + n; k++) {
            for (int i = 0; i <= Math.min(k, m - 1); i++) {
                if (k - i < 3 && k - i >= 0)
                    hold += nums1[i] * nums2[k - i];
            }

            result[k] = hold % 10;
            hold /= 10;
        }
        return result;
    }
}
