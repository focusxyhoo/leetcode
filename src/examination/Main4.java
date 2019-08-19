package algorithms;

import java.util.Scanner;

/**
 * created with IntelliJ IDEA
 * author      : focusxyhoo
 * date        : 2019-08-17
 * time        : 21:06
 * description :
 */
public class Main4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
        }

        int[] after = new int[n];
        int[] before = new int[n];

        for (int i = 0; i < n; i++) {
            int maxHeight = 0;
            int index = i + 1;
            after[i] = 0;
            while (index < n) {
                if (nums[index] > maxHeight) {
                    after[i]++;
                    maxHeight = nums[index];
                }
                index++;
            }

            int maxHeight2 = 0;
            int index2 = i - 1;
            before[i] = 0;
            while (index2 >= 0) {
                if (nums[index2] > maxHeight2) {
                    before[i]++;
                    maxHeight2 = nums[index2];
                }
                index2--;
            }
        }

//        for (int i = 0; i < n; i++) {
//            int maxHeight = 0;
//            int index = i - 1;
//            before[i] = 0;
//            while (index >= 0) {
//                if (nums[index] > maxHeight) {
//                    before[i]++;
//                    maxHeight = nums[index];
//                }
//                index--;
//            }
//        }

        for (int i = 0; i < n; i++) {
            System.out.print(before[i] + after[i] + 1);
            if (i != n - 1) System.out.print(" ");
        }
    }
}
