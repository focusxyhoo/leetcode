package leetcode.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * created with IntelliJ IDEA
 * author      : focusxyhoo
 * date        : 2019-08-16
 * time        : 16:38
 * description : https://leetcode.com/problems/permutation-sequence/
 * 思路一：利用 leetcode 46 题求全排列
 */
public class T60_PermutationSequence {
    public static void main(String[] args) {
        System.out.println(getPermutation(4, 9));
    }

    private static int count;
    private static boolean flag = false;

    /**
     * 超时
     *
     * @param n
     * @param k
     * @return
     */
    public static String getPermutation(int n, int k) {
        count = k;
        List<List<Integer>> result = new ArrayList<>();
        backtrack(result, new ArrayList<>(), n);
        List<Integer> ans = result.get(k - 1);
        StringBuilder sb = new StringBuilder();
        for (Integer i : ans) {
            sb.append(i);
        }
        return sb.toString();
    }

    private static void backtrack(List<List<Integer>> result, List<Integer> tempList, int n) {
        if (flag) return;
        if (tempList.size() == n) {
            result.add(new ArrayList<>(tempList));
            count--;
            if (count == 0) flag = true;
        } else {
            for (int i = 0; i < n; i++) {
                if (!tempList.contains(i + 1)) {
                    tempList.add(i + 1);
                    backtrack(result, tempList, n);
                    tempList.remove(tempList.size() - 1);
                }
            }
        }
    }

}
