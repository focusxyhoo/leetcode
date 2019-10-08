package examination;

import java.util.Scanner;

/**
 * created with IntelliJ IDEA
 * author      : focusxyhoo
 * date        : 2019/9/21
 * time        : 15:41
 * description :
 */
public class Netease02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        for (int j = 0; j < n; j++) {
            int[] nums = new int[4];
            for (int i = 0; i < 4; i++) {
                nums[i] = scanner.nextInt();
            }
            int count = 0;
            while (nums[0] < nums[1]) {
                int temp = nums[0] + nums[2];
                count++;
                if (temp >= nums[1]) {
                    break;
                } else {
                    nums[2] *= nums[3];
                }
            }
            System.out.println(count);
        }

    }
}
