package examination;

import java.util.Arrays;
import java.util.Scanner;

/**
 * created with IntelliJ IDEA
 * author      : focusxyhoo
 * date        : 2019/8/23
 * time        : 19:11
 * description :
 */
public class BeikeLast01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int sum = scanner.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
        }

        Arrays.sort(nums);
        int count = 0;
        int temp = 0;
        for (int i = 0; i < n; i++) {
            temp += nums[i];
            count++;
            if (temp <= sum) continue;
            else break;
        }
        System.out.println(count - 1);
    }
}
