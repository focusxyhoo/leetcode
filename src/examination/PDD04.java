package examination;

import java.util.Scanner;

/**
 * created with IntelliJ IDEA
 * author      : focusxyhoo
 * date        : 2019/9/25
 * time        : 15:47
 * description :
 */
public class PDD04 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        for (int i = 0; i < t; i++) {
            int n = scanner.nextInt();
            int m = scanner.nextInt();
            int[] weekends = new int[m];
            int[] choices = new int[m];
            for (int j = 0; j < m; j++) {
                weekends[j] = scanner.nextInt();
            }
            for (int j = 0; j < m; j++) {
                choices[j] = scanner.nextInt();
            }
            if (m == 0) System.out.println((int) ((4 * Math.pow(3, n - 1)) % 1000000007));

            int count = 1;

            for (int j = 0; j < n; j++) {
                
            }
        }
    }

}
