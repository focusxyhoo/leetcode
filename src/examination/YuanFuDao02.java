package examination;

import java.util.Arrays;
import java.util.Scanner;

/**
 * created with IntelliJ IDEA
 * author      : focusxyhoo
 * date        : 2019/8/24
 * time        : 16:25
 * description :
 */
public class YuanFuDao02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int c = scanner.nextInt();
        int[] ans = new int[c];
        for (int i = 0; i < c; i++) {
            int t = scanner.nextInt();
            int[] nums = new int[t];
            for (int j = 0; j < t; j++) {
                nums[j] = scanner.nextInt();
            }
            ans[i] = getCount(nums);
        }
        for (int i = 0; i < c; i++) {
            System.out.println(ans[i]);
        }
    }

    private static int getCount(int[] nums) {
        int count = 0;
        Arrays.sort(nums);
        int index = nums.length - 3;
        while (nums[index] != 0){
            int temp = nums[index];
            count += temp;
            nums[index] -= temp;
            nums[index + 1] -= temp;
            nums[index + 2] -= temp;
            Arrays.sort(nums);
        }
        return count;
    }

}
