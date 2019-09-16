package examination;

import java.util.*;

/**
 * created with IntelliJ IDEA
 * author      : focusxyhoo
 * date        : 2019/9/1
 * time        : 20:12
 * description :
 */
public class Tecent02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        TreeSet<Node> set = new TreeSet<>();
        for (int i = 0; i < n; i++) {
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            set.add(new Node(a, b));
        }
        int sum = 0;
        Iterator<Node> it = set.descendingIterator();
        int before = 0, after = n - 1;
        for (;it.hasNext();) {
            Node temp = it.next();
            sum += before * temp.a;
            sum += after * temp.b;
            before++;
            after--;
        }
        System.out.println(sum);
    }

    private static class Node implements Comparable{
        int a;
        int b;
        public  Node(int a, int b) {
            this.a = a;
            this.b = b;
        }

        @Override
        public int compareTo(Object o) {
            Node temp = (Node) o;
            if (this.a > temp.a) return 1;
            else if (this.a < temp.a) return -1;
            else {
                if (this.b < temp.b) return 1;
                else if (this.b == temp.b) return 0;
                else return -1;
            }
        }
    }
}
