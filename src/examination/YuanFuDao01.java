package examination;

import java.util.HashMap;
import java.util.Scanner;

/**
 * created with IntelliJ IDEA
 * author      : focusxyhoo
 * date        : 2019/8/24
 * time        : 15:59
 * description :
 */
public class YuanFuDao01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
        }

        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            if (!map.containsKey(nums[i])) map.put(nums[i], 1);
            else map.put(nums[i], map.get(nums[i]) + 1);
        }

        for (int i = 0; i < n; i++) {
            if (map.get(nums[i]) > m) continue;
            System.out.print(nums[i]);
            if (i != n - 1) System.out.print(" ");
        }
    }
}
