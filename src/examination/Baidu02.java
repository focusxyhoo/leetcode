package examination;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * created with IntelliJ IDEA
 * author      : focusxyhoo
 * date        : 2019/9/10
 * time        : 20:14
 * description :
 */
public class Baidu02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        Deque<Integer> stack = new LinkedList<>();
        stack.push(n);
        int ans = 0;
        while (!stack.isEmpty()) {
            int temp = stack.poll();
            int[] camp = isCamp(temp, k);
//            System.out.println(Arrays.toString(camp));
            if (camp != null) {
                stack.push(camp[0]);
                stack.push(camp[1]);
            } else ans++;
        }
        System.out.println(ans);
    }

    private static int[] isCamp(int n, int k) {
        int temp1 = n + k;
        int temp2 = n - k;
        if (temp1 % 2 != 0 || temp2 % 2 != 0 || n - k <= 0) return null;
        return new int[]{temp1 / 2, temp2 / 2};
    }

}
