package leetcode.easy;

import java.util.Scanner;

/**
 * created with IntelliJ IDEA
 * author      : focusxyhoo
 * date        : 2019-07-05
 * time        : 08:58
 * description :
 */
public class T746_MinCostClimbingStairs {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String[] tokens = scanner.nextLine().split(" ");
            int[] nums = new int[tokens.length];
            for (int i = 0; i < nums.length; i++) {
                nums[i] = Integer.parseInt(tokens[i]);
            }
            System.out.println(minCostClimbingStairs(nums));
        }
    }

    public static int minCostClimbingStairs(int[] cost) {

        int f1 = cost[0], f2=cost[1];
        for (int i = 2; i < cost.length; i++) {
            int temp = cost[i] + Math.min(f1, f2);
            f1 = f2;
            f2 = temp;
        }
        return Math.min(f1, f2);
    }
}
