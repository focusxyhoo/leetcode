package algorithms;

import java.util.Scanner;

/**
 * created with IntelliJ IDEA
 * author      : focusxyhoo
 * date        : 2019-08-10
 * time        : 18:39
 * description :
 */
public class Beike01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        long[] nums = new long[n];
        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
        }

        long min = Integer.MAX_VALUE;
        long[] result = new long[2];
        for (int i = 0; i < n - 1; i++) {
            long temp = getAbs(nums[i], nums[i + 1]);
            if (min > temp) {
                min = temp;
                result[0] = nums[i];
                result[1] = nums[i + 1];
            }
        }

        System.out.println(result[0] + " " + result[1]);
    }

    private static long getAbs(long a, long b) {
        return a >= b ? (a - b) : (b - a);
    }
}
