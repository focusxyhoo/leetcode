package algorithms;

import java.util.Scanner;

/**
 * created with IntelliJ IDEA
 * author      : focusxyhoo
 * date        : 2019-07-12
 * time        : 21:41
 * description :
 */
public class Main1 {

    private static long temp;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int nLine = scanner.nextInt();
        int[] nums = new int[nLine];
        for (int i = 0; i < nLine; i++) {
            nums[i] = scanner.nextInt();
        }
        for (int item : nums) {
            isSquare(item);
            System.out.println();
        }

    }

    public static int find(int num) {

        for (int i = num >> 1; i > 0; i++) {

        }

        return -1;
    }

    public static void isSquare(long n) {
        long i;
        for (i = 1; n > 0; i += 2) {
            n -= i;
        }
        temp = (i - 1) / 2;
    }
}
