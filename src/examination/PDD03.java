package examination;

import java.util.Scanner;

/**
 * created with IntelliJ IDEA
 * author      : focusxyhoo
 * date        : 2019/9/25
 * time        : 15:24
 * description :
 */
public class PDD03 {
    static int N;
    static int M;
    static long K;
    static boolean isGoon = true;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        N = scanner.nextInt();
        M = scanner.nextInt();
        K = scanner.nextLong();
        StringBuilder sb = new StringBuilder();
        dfs(0, 0, sb);
    }


    private static void dfs(int aNum, int bNum, StringBuilder sb) {
        if (!isGoon) return;
        if (aNum > N || bNum > M) return;
        if (aNum > 0 || bNum > 0) K--;
        if (K == 0) {
            System.out.println(sb.toString());
            isGoon = false;
        }

        sb.append('a');
        dfs(aNum + 1, bNum, sb);
        sb.deleteCharAt(sb.length() - 1);

        sb.append('b');
        dfs(aNum, bNum + 1, sb);
        sb.deleteCharAt(sb.length() - 1);

    }
}
