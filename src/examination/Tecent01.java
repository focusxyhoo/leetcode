package examination;

import java.util.Scanner;

/**
 * created with IntelliJ IDEA
 * author      : focusxyhoo
 * date        : 2019/9/1
 * time        : 20:00
 * description :
 */
public class Tecent01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int[] boxes = new int[n];
        int[] keys = new int[m];
        for (int i = 0; i < n; i++) {
            boxes[i] = scanner.nextInt();
        }
        for (int i = 0; i < m; i++) {
            keys[i] = scanner.nextInt();
        }
        int ouShuBoxes = 0, jiShuBoxes = 0;
        int ouShuKeys = 0, jiShuKeys = 0;
        for (int i = 0; i < n; i++) {
            if (isOuShu(boxes[i])) ouShuBoxes++;
            else jiShuBoxes++;
        }
        for (int i = 0; i < m; i++) {
            if (isOuShu(keys[i])) ouShuKeys++;
            else jiShuKeys++;
        }
        int max1 = ouShuBoxes;
        max1 = Math.min(max1, jiShuKeys);
        int max2 = ouShuKeys;
        max2 = Math.min(max2, jiShuBoxes);
        System.out.println(max1 + max2);
    }

    private static boolean isOuShu(int num) {
        return num % 2 == 0;
    }
}
