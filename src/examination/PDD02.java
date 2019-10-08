package examination;

import java.util.Arrays;
import java.util.Scanner;

/**
 * created with IntelliJ IDEA
 * author      : focusxyhoo
 * date        : 2019/9/25
 * time        : 15:16
 * description :
 */
public class PDD02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int[] left = new int[m];
        int[] right = new int[m];
        for (int i = 0; i < m; i++) {
            left[i] = scanner.nextInt();
            right[i] = scanner.nextInt();
        }
        boolean[] isTree = new boolean[n];
        Arrays.fill(isTree, false);

        int count = 0;
        for (int i = 0; i < m; i++) {
            int temp = left[i];
            for (int j = temp; j <= right[i]; j++) {
                if (!isTree[j - 1]) {
                    isTree[j - 1] = true;
                    count++;
                }
            }
            System.out.println(count);
        }
    }
}
