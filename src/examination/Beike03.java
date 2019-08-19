package algorithms;

import java.util.Arrays;
import java.util.Scanner;

/**
 * created with IntelliJ IDEA
 * author      : focusxyhoo
 * date        : 2019-08-10
 * time        : 19:43
 * description :
 */
public class Beike03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
        }

        Arrays.sort(nums);
        int result = 0;
        for (int i = 0; i < n; i++) {
            int temp = getCurrentSum(nums, i);
            result += temp;
        }
        System.out.println(result);

    }

    private static int getCurrentSum(int[] nums, int index) {
        int high = nums.length - 1;
        while (high > index) {
            if (isCompete(nums[high], nums[index])) break;
            high--;
        }
        return high - index;
    }

    private static boolean isCompete(int a, int b) {
        int min = Math.min(a, b);
        int max = Math.max(a, b);
        if (min < max * 0.9) return false;
        return true;
    }
}
