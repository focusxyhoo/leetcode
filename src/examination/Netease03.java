package examination;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * created with IntelliJ IDEA
 * author      : focusxyhoo
 * date        : 2019/9/21
 * time        : 16:15
 * description :
 */
public class Netease03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        for (int i = 0; i < t; i++) {
            int n = scanner.nextInt();
            int[] nums = new int[n];
            for (int j = 0; j < n; j++) {
                nums[j] = scanner.nextInt();
            }

            int sum = 0;
            List<Integer> list = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                if (list.isEmpty() || (list.get(list.size() - 1) < nums[j] && nums[j] >= sum)) {
                    list.add(nums[j]);
                    sum += nums[j];
                } else {
                    int low = 0, high = list.size() - 1;
                    while (low < high) {
                        int mid = (low + high) / 2;
                        if (list.get(mid) < nums[j]) low = mid + 1;
                        else high = mid - 1;
                    }
                    sum -= list.get(low);
                    list.remove(low);
                    list.add(low, nums[j]);
                    sum += list.get(low);
                }
            }
            System.out.println(list.size());
        }
    }
}
