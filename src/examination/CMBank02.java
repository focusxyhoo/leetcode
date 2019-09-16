package examination;

import java.util.Scanner;

/**
 * created with IntelliJ IDEA
 * author      : focusxyhoo
 * date        : 2019/9/6
 * time        : 14:55
 * description :
 */
public class CMBank02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        total = scanner.nextInt();
        dfs(0, 0, 0);
        System.out.println(count);
    }
    private static int total;
    private static int count = 0;
    private static void dfs(int i, int nb, int nc) {
        // DO NOT change the order of the two IFs.
        if (nb == 3 || nc == 2) return; // first check whether it is legal or not,
        if (i == total) { // then watch out the end condition.
            count++;
            return;
        }
        // case 1 : current character is A;
        dfs(i + 1, 0, nc);
        // case 2 : current character is B;
        dfs(i + 1, nb + 1, nc);
        // case 3 : current character is C;
        dfs(i + 1, 0, nc + 1);
    }
}
