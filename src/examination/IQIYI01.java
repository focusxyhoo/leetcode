package examination;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * created with IntelliJ IDEA
 * author      : focusxyhoo
 * date        : 2019/9/8
 * time        : 15:17
 * description :
 */
public class IQIYI01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] nums = new int[n - 1];
        for (int i = 0; i < n - 1; i++) {
            nums[i] = scanner.nextInt();
        }
        boolean[] used = new boolean[n + 1];
        Arrays.fill(used, false);
//        List<List<Integer>> ans = new ArrayList<>();
//        backtrack(ans, new ArrayList<>(), nums, used);
//        System.out.println(ans.size());
        dfs(1, 0, nums, 1, used);
        System.out.println(count);
    }

//    private static void backtrack(List<List<Integer>> result, List<Integer> tempList, int[] nums, boolean[] used) {
//        if (tempList.size() == nums.length + 1) {
//            result.add(new ArrayList<>(tempList));
//            return;
//        }
//        for (int i = 1; i <= nums.length + 1; i++) {
//            if (!used[i]) {
//                tempList.add(i);
//                used[i] = true;
//                if (tempList.size() > 1) {
//                    if (nums[tempList.size() - 2] == 0) {
//                        if (i < tempList.get(tempList.size() - 2)) {
//                            tempList.remove(tempList.size() - 1);
//                            used[i] = false;
//                            continue;
//                        }
//                    } else {
//                        if (i > tempList.get(tempList.size() - 2)) {
//                            tempList.remove(tempList.size() - 1);
//                            used[i] = false;
//                            continue;
//                        }
//                    }
//                }
//                backtrack(result, tempList, nums, used);
//                tempList.remove(tempList.size() - 1);
//                used[i] = false;
//            }
//        }
//    }

    private static int count = 0;
    private static void dfs(int prev, int curr, int[] nums, int len, boolean[] used) {
        if (len > 1) {
            if (nums[len - 1] == 0) {
                if (prev > curr) {
                    used[curr] = false;
                    return;
                }
            } else if (prev < curr) {
                used[curr] = false;
                return;
            }
        }
        if (len == nums.length + 1) {
            count++;
            count = count % 1000000007;
            Arrays.fill(used, false);
            return;
        }
        used[curr] = true;
        for (int i = 1; i <= nums.length + 1; i++) {
            if (!used[i]) {
                dfs(curr, i, nums, len + 1, used);
                dfs(prev, i, nums, len, used);
            }
        }
    }
}
