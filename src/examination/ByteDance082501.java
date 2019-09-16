package examination;

import java.util.*;

/**
 * created with IntelliJ IDEA
 * author      : focusxyhoo
 * date        : 2019/8/25
 * time        : 18:54
 * description :
 */
public class ByteDance082501 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[][] nums = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                nums[i][j] = scanner.nextInt();
            }
        }

        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            List<Integer> tempList = new ArrayList<>();
            for (int j = i + 1; j < n; j++) {
                if (nums[i][j] >= 3) {
                    tempList.add(j);
                }
            }
            map.put(i, tempList);
        }

        boolean[] used = new boolean[n];
        List<Set<Integer>> ans = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (used[i]) continue;
            Set<Integer> temp = new HashSet<>();
            recurse(map, ans, temp, used, i);
            ans.add(temp);
        }
        System.out.println(ans.size());

    }

    private static void recurse(Map<Integer, List<Integer>> map, List<Set<Integer>> ans, Set<Integer> temp, boolean[] used, int index) {
        List<Integer> tempList = map.get(index);
        if (tempList == null) return;
        temp.add(index);
        used[index] = true;
        for (Integer i : tempList) {
            if (used[i]) continue;
            temp.add(i);
            used[i] = true;
            recurse(map, ans, temp, used, i);
        }
    }

}
