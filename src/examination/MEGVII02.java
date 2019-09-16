package examination;

import java.util.*;

/**
 * created with IntelliJ IDEA
 * author      : focusxyhoo
 * date        : 2019/9/9
 * time        : 21:05
 * description :
 */
public class MEGVII02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        String s = scanner.next();
        int[] dp = new int[n];
        int max = 0;
        int pre = 0;
        List<Character> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            char temp = s.charAt(i);


            max = Math.max(max, dp[i]);
            System.out.println(max);
        }
    }
}
