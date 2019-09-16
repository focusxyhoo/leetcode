package examination;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * created with IntelliJ IDEA
 * author      : focusxyhoo
 * date        : 2019/9/10
 * time        : 20:38
 * description :
 */
public class Baidu03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        List<Node> list = new ArrayList<>();
        for (int i = 0; i < n - 1; i++) {
            int u = scanner.nextInt();
            int v = scanner.nextInt();
        }
    }

    private class Node {
        public int val;
        public int left;
        public int right;
    }
}
