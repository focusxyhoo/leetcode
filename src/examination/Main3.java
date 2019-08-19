package examination;

import java.util.*;

/**
 * created with IntelliJ IDEA
 * author      : focusxyhoo
 * date        : 2019-08-17
 * time        : 21:22
 * description :
 */
public class Main3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int l = scanner.nextInt();
        List<IntervalH> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int start = scanner.nextInt();
            int end = scanner.nextInt();
            list.add(new IntervalH(start, end));
        }
        Collections.sort(list, (a, b) -> {
            if (a.start < b.start) return -1;
            else if (a.start > b.start) {
                return 1;
            } else {
                if (a.end < b.end) return -1;
                else if (a.end > b.end) return 1;
                else return 0;
            }
        });

        int[] dp = new int[n];
        for (int i = 0; i < list.size(); i++) {

        }

    }
}

class IntervalH {
    int start;
    int end;

    public IntervalH(int s, int e) {
        start = s;
        end = e;
    }
}
