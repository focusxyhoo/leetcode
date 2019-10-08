package examination;

import java.util.Scanner;

/**
 * created with IntelliJ IDEA
 * author      : focusxyhoo
 * date        : 2019/9/20
 * time        : 20:37
 * description :
 */
public class Tecent092003 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
        }
        for (int i = 0; i < k; i++) {
            int index = findMinElementIndex(nums);
            int temp = nums[index];
            System.out.println(temp);
            subtract(nums, temp);

        }
    }

    private static int findMinElementIndex(int[] nums) {
        int min = nums[0];
        int ansIndex = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != 0) {
                min = Math.min(min, nums[i]);
                ansIndex = i;
            }
        }
        return ansIndex;
    }

    private static void subtract(int[] nums, int sub) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[i] -= sub;
            }
        }
    }
}
