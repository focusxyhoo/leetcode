package examination;

import java.util.*;

/**
 * created with IntelliJ IDEA
 * author      : focusxyhoo
 * date        : 2019/9/1
 * time        : 20:53
 * description :
 */
public class Tecent5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        int k = scanner.nextInt();
        for (int i = 0; i < t; i++) {
            int[] lens = new int[2];
            lens[0] = scanner.nextInt();
            lens[1] = scanner.nextInt();
            List<List<Integer>> ans = new ArrayList<>();
            backtrack(ans, new ArrayList<>(), lens, k);
            System.out.println(ans.size());
        }
    }

    private static void backtrack(List<List<Integer>> result, List<Integer> tempList, int[] lens, int k) {
        if (tempList.size() >= lens[0] && tempList.size() <= lens[1]) {
            result.add(new ArrayList<>(tempList));
        } else if (tempList.size() > lens[1]) return;

        int[] nums = {0, 1};
        for (int i = 0; i < nums.length; i++) {
            int temp = nums[i];
            if (temp == 0) {
                tempList.add(temp);
                backtrack(result, tempList, lens, k);
                tempList.remove(tempList.size() - 1);
            } else {
                int count = k;
                while (count > 0) {
                    tempList.add(temp);
                    count--;
                }
                backtrack(result, tempList, lens, k);
                count = k;
                while (count > 0) {
                    tempList.remove(tempList.size() - 1);
                    count--;
                }
            }
        }
    }
}
