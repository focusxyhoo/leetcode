package nowcoder;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/**
 * created with IntelliJ IDEA
 * author      : focusxyhoo
 * date        : 2019-08-05
 * time        : 13:08
 * description : 搭积木
 */
public class Tower {

    private static class Rect {
        public int w;
        public int l;

        public Rect(int w, int l) {
            this.w = w;
            this.l = l;
        }

        @Override
        public String toString() {
            return "(" + w + ", " + l + ")";
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        Rect[] objects = new Rect[n];
        for (int i = 0; i < n; i++) {
            int tempW = scanner.nextInt();
            int tempL = scanner.nextInt();
            objects[i] = new Rect(tempW, tempL);
        }
        Arrays.sort(objects, new Comparator<Rect>() {
            @Override
            public int compare(Rect o1, Rect o2) {
                if (o1.w > o2.w) return 1;
                else if (o1.w < o2.w) return -1;
                else {
                    if (o1.l < o2.l) return -1;
                    else if (o1.l > o2.l) return 1;
                    else return 0;
                }
            }
        });
        System.out.println(Arrays.toString(objects));

        int count = 0;

    }
}
