package examination;

import java.util.Arrays;
import java.util.Scanner;

/**
 * created with IntelliJ IDEA
 * author      : focusxyhoo
 * date        : 2019/9/25
 * time        : 15:01
 * description :
 */
public class PDD01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
        }
        Arrays.sort(nums);
        int len = 2 * m;
        int[] numsLast = new int[len];
        for (int i = 0; i < len; i++) {
            numsLast[i] = nums[i];
        }
        int minSum = 0;
        for (int i = 0; i < m; i++) {
            minSum += numsLast[i] * numsLast[len - 1 - i];
        }
        System.out.println(minSum);
    }
}
