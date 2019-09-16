package examination;

import java.util.Scanner;

/**
 * created with IntelliJ IDEA
 * author      : focusxyhoo
 * date        : 2019/8/23
 * time        : 19:11
 * description : passing rate: 91
 */
public class BeikeLast03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        long m = scanner.nextLong();
        int[][] nums = new int[n][2];
        for (int i = 0; i < n; i++) {
            nums[i][0] = scanner.nextInt();
            nums[i][1] = scanner.nextInt();
        }

        int count = 0;
        long tempWeight = 0;
        for (int i = 0; i < n; i++) {
            int get = take(nums[i][0], nums[i][1], tempWeight, m);
//            System.out.println(get);
            tempWeight += get * nums[i][1];
            count += get;
        }
        System.out.println(count);
    }

    private static int take(int total, int weight, long tempWeight, long m) {
        int count = 0;
        for (; count <= total && tempWeight <= m; count++) {
            tempWeight += weight;
        }
        return count - 1;
    }
}
