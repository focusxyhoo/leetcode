package examination;

import java.util.Scanner;

/**
 * created with IntelliJ IDEA
 * author      : focusxyhoo
 * date        : 2019/9/11
 * time        : 19:38
 * description :
 */
public class XiaoMi01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[][] nums = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                nums[i][j] = scanner.nextInt();
            }
        }
        solution(nums);

    }
    static void solution(int[][] input) {
        int[][] ans = new int[input.length][input.length];
        for (int i = 0; i < input.length; i++) {
            int index = 0;
            for (int j = 0; j < input.length; j++) {
                if (input[i][j] == 0) continue;
                if (j < input.length - 1) {
                    if (input[i][j] == input[i][j + 1]) {
                        ans[i][index] = input[i][j] * 2;
                        index++;
                        j++;
                    } else {
                        ans[i][index] = input[i][j];
                        index++;
                    }
                } else {
                    ans[i][index] = input[i][j];
                }
            }
        }
        for (int i = 0; i < input.length; i++) {
            for (int j = 0; j < input.length; j++) {
                System.out.print(ans[i][j]);
                if (j != input.length - 1) System.out.print(" ");
            }
            System.out.println();
        }
    }
}
