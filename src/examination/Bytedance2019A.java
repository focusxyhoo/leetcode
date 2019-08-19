package examination;

import java.util.Scanner;

/**
 * created with IntelliJ IDEA
 * author      : focusxyhoo
 * date        : 2019-07-02
 * time        : 17:07
 * description :
 */
public class Bytedance2019A {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
//        String[] line = scanner.nextLine().split(",");
//        int m = Integer.parseInt(line[0]);
//        int n = Integer.parseInt(line[1]);
//        int[][] nums = new int[m][n];
//        int[][] backup = new int[m][n];
//
//        for (int i = 0; i < m; i++) {
//            line = scanner.nextLine().split(",");
//            for (int j = 0; j < n; j++) {
//                nums[i][j] = Integer.parseInt(line[j]);
//                backup[i][j] = 0;
//            }
//        }
//        scanner.close();
//
//        int count = 0;
//        int max = 0;
//        for (int i = 0; i < m; i++) {
//            for (int j = 0; j < n; j++) {
//                if (nums[i][j] == 1 && backup[i][j] == 0) {
//                    count++;
//                    int num = getGroup(nums, backup, i, j);
//                    max = num > max ? num : max;
//                }
//            }
//        }
//        System.out.println(count + "," + max);
        int m = scanner.nextInt();
        int n = scanner.nextInt();
        int l = scanner.nextInt();
        System.out.println(m + "," + n + "," + l);


    }

    private static int getGroup(int[][] nums, int[][] backup, int i, int j) {
        if (i < 0 || j < 0 || i > nums.length - 1 || j > nums[0].length - 1 || nums[i][j] == 0 || backup[i][j] == 1) {
            return 0;
        } else {
            backup[i][j] = 1;
            return 1 + getGroup(nums, backup, i - 1, j - 1) + getGroup(nums, backup, i - 1, j) +
                    getGroup(nums, backup, i - 1, j + 1) + getGroup(nums, backup, i, j - 1) +
                    getGroup(nums, backup, i, j + 1) + getGroup(nums, backup, i + 1, j - 1) +
                    getGroup(nums, backup, i + 1, j) + getGroup(nums, backup, i + 1, j + 1);
        }
    }
}
