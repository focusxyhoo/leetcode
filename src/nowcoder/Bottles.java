package nowcoder;

import java.util.Scanner;

/**
 * created with IntelliJ IDEA
 * author      : focusxyhoo
 * date        : 2019-07-04
 * time        : 16:32
 * description :
 */
public class Bottles {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            if (n == 0) break;
            int result = 0;
            int left = 0;
            while (n >= 3) {
                left = n % 3;
                n /= 3;
                result += n;
                n += left;
            }
            if (n == 2) {
                System.out.println(result + 1);
            } else {
                System.out.println(result);
            }
        }
    }
}
