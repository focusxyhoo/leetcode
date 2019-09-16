package examination;

import java.util.Arrays;
import java.util.Scanner;

/**
 * created with IntelliJ IDEA
 * author      : focusxyhoo
 * date        : 2019/8/23
 * time        : 20:10
 * description : passing rate: 18
 */
public class BeikeLast04 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
        }

        Arrays.sort(nums);
        int left = 0, right = n - 1;
        int sumLeft = nums[0], sumRight = nums[right];
        while (right - left > 1) {
            if (sumLeft <= sumRight) {
                left++;
                sumLeft += nums[left];
            } else {
                right--;
                sumRight += nums[right];
            }
        }
//        System.out.println(left + " " + right);
        System.out.println(Math.abs(sumLeft - sumRight) + " " + Math.abs(n - 2 * left - 2));
    }
}
