package algorithms;

import java.util.Scanner;

/**
 * created with IntelliJ IDEA
 * author      : focusxyhoo
 * date        : 2019-07-12
 * time        : 20:59
 * description :
 */
public class Solution {

    private static long temp;

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        long n = scanner.nextLong();
//        System.out.println(isSquare(n));
        System.out.println(solve(n));
    }

    public static int solve(long n) {
        int count = 0;
        isSquare(n);
        while (n > 1) {

            if (temp * temp < n) {
                n--;
                count++;

            } else if (temp * temp > n) {
                temp--;
            } else {
                n = temp;
                count++;

            }
        }
        return count;
    }

    public static void isSquare(long n) {
        long i;
        for (i = 1; n > 0; i += 2) {
            n -= i;
        }
        temp = (i - 1) / 2;
    }

}
