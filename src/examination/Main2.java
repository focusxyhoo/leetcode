package algorithms;

import java.util.Arrays;
import java.util.Scanner;

/**
 * created with IntelliJ IDEA
 * author      : focusxyhoo
 * date        : 2019-08-17
 * time        : 20:24
 * description :
 */
public class Main2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] nums = new int[1 << n];
        for (int i = 0; i < (1 << n); i++) {
            nums[i] = scanner.nextInt();
        }
        int m = scanner.nextInt();
        int[] queries = new int[m];
        for (int i = 0; i < m; i++) {
            queries[i] = scanner.nextInt();
        }

        for (int i = 0; i < m; i++) {
            if (queries[i] == 0) {
                System.out.println(getInverseCount(nums));
            } else if (queries[i] >= n) {
                reverse(nums, 0, (1 << n) - 1);
                System.out.println(getInverseCount(nums));
            } else {
                int count = 1 << queries[i];
                int index = 0;
                while (index < nums.length) {
                    reverse(nums, index, index + count - 1);
                    index += count;
                }
                System.out.println(getInverseCount(nums));
            }
        }
    }

    public static int getInverseCount(int[] nums) {
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] < nums[i]) count++;
            }
        }
        return count;
    }

    public static void reverse(int[] nums, int start, int end) {
        while (start < end) {
            swap(nums, start, end);
            start++;
            end--;
        }
    }

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
