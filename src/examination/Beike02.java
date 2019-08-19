package examination;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * created with IntelliJ IDEA
 * author      : focusxyhoo
 * date        : 2019-08-10
 * time        : 19:13
 * description :
 */
public class Beike02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
        }
        int result = 1;
        for (int i = 0; i < n; i++) {
            int temp = 1;
            int prev = nums[i];
            if (n - i < result) break;
            for (int j = i + 1; j < n; j++) {
                if (nums[j] > prev) {
                    temp++;
                    prev = nums[j];
                }
            }
            result = Math.max(temp, result);
        }
        System.out.println(result);

    }
}
