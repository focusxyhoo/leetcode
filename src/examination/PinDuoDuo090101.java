package examination;

import java.util.Iterator;
import java.util.Scanner;
import java.util.TreeSet;

/**
 * created with IntelliJ IDEA
 * author      : focusxyhoo
 * date        : 2019/9/1
 * time        : 14:55
 * description :
 */
public class PinDuoDuo090101 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        String[] nums = s.split(",");
        int n = nums.length;
        String last = nums[n - 1];
        nums[n - 1] = last.split(";")[0];
        int N = Integer.parseInt(last.split(";")[1]);

        TreeSet<Integer> jishu = new TreeSet<>();
        TreeSet<Integer> oushu = new TreeSet<>();
        for (int i = 0; i < n; i++) {
            if (isOushu(nums[i])) oushu.add(Integer.parseInt(nums[i]));
            else jishu.add(Integer.parseInt(nums[i]));
        }

        int count = 0;
        Iterator<Integer> it = oushu.descendingIterator();
        for (;it.hasNext() && count < N;) {
            System.out.print(it.next());
            if (count != N - 1) System.out.print(",");
            count++;
        }
        if (N > oushu.size()) {
            int left = N - oushu.size();
            Iterator<Integer> itLeft = jishu.descendingIterator();
            for (;itLeft.hasNext() && left > 0;) {
                System.out.print(itLeft.next());
                if (left != 1) System.out.print(",");
                left--;
            }
        }
    }

    private static boolean isOushu(String s) {
        char temp = s.charAt(s.length() - 1);
        return temp == '0' || temp == '2' || temp == '4' || temp == '6' || temp == '8';
    }
}
