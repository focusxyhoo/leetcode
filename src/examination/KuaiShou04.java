package examination;

import java.util.Arrays;
import java.util.Scanner;

/**
 * created with IntelliJ IDEA
 * author      : focusxyhoo
 * date        : 2019/9/16
 * time        : 21:57
 * description : pass rate 0.8571
 */
public class KuaiShou04 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
        }
        Arrays.sort(nums);
        int left = 0, right = n - 1;
        int leftSum = nums[left], rightSum = nums[right];
        while (left < right) {
            if (leftSum < rightSum) {
                if (left + 1 < right) {
                    leftSum += nums[++left];
                } else break;
            } else {
                if (right - 1 > left) {
                    rightSum += nums[--right];
                } else break;
            }
        }
        System.out.println(Math.abs(leftSum - rightSum));
    }
}
