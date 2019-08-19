package algorithms;

import java.util.Arrays;
import java.util.Scanner;

/**
 * created with IntelliJ IDEA
 * author      : focusxyhoo
 * date        : 2019-08-10
 * time        : 19:57
 * description :
 */
public class Beike04 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
        }
        if (n == 1) {
            System.out.println(0);
            return;
        }

        int low = findFisrtDec(nums);
        int high = findLastInc(nums);
//        System.out.println(low + " " + high);
        if (low == nums.length - 1 || low == 0) {
            System.out.println(0);
            return;
        }
        int result = 0;
        high--;
        while (low < high) {
            if (nums[low] < nums[low - 1] + 1) {
                result += nums[low - 1] + 1 - nums[low];
                nums[low] = nums[low - 1] + 1;
                low++;

            }
            if (nums[high] < nums[high + 1] + 1) {
                result += nums[high + 1] + 1 - nums[high];
                nums[high] = nums[high + 1] + 1;
                high--;

            }
        }
        System.out.println(Arrays.toString(nums));
        System.out.println(result);
    }

    private static int findFisrtDec(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < nums[i - 1]) {
                return i;
            }
        }
        return nums.length - 1;
    }

    private static int findLastInc(int[] nums) {
        for (int i = nums.length - 1; i >= 1; i--) {
            if (nums[i - 1] < nums[i]) {
                return i;
            }
        }
        return 0;
    }
}
