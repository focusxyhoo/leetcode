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
        System.out.println(getPermutation2(4, 9));
    }

    private static int count;

    /**
     * Runtime: 261 ms, faster than 11.59% of Java online submissions for Permutation Sequence.
     * Memory Usage: 34.2 MB, less than 100.00% of Java online submissions for Permutation Sequence.
     * 时间复杂度仍然很高。
     *
     * @param n
     * @param k
     * @return
     */
    public static String getPermutation(int n, int k) {
        count = k;
        List<Integer> result = backtrack(new ArrayList<>(), n, new boolean[n]);

        StringBuilder sb = new StringBuilder();
        for (Integer i : result) {
            sb.append(i);
        }
        return sb.toString();
    }

    private static List<Integer> backtrack(List<Integer> tempList, int n, boolean[] used) {
        if (tempList.size() == n) {
            if (--count == 0) return tempList;
        } else {
            for (int i = 0; i < n; i++) {
//                if (!tempList.contains(i + 1)) { // contains 时间复杂度为 O(n)
                if (!used[i]) {
                    used[i] = true;
                    tempList.add(i + 1);
                    List<Integer> result = backtrack(tempList, n, used);
                    if (result != null) return result;
                    used[i] = false;
                    tempList.remove(tempList.size() - 1);
                }
            }
        }
        return null;
    }

    /**
     * 根据 k 的值依次找出每一位的值。
     * 第 i 元素有 (n - i)! 种排列。根据这个特点，为确定第一个元素，用 k / (n - 1)! 作为 index 来找，然后将 k 赋值为 k % (n - 1)!，
     * 接着确定第二个元素，第二个元素有 (n - 2)! 种排列。依次重复循环。
     * Runtime: 1 ms, faster than 99.28% of Java online submissions for Permutation Sequence.
     * Memory Usage: 34.3 MB, less than 100.00% of Java online submissions for Permutation Sequence.
     *
     * @param n
     * @param k
     * @return
     */
    private static String getPermutation2(int n, int k) {
        StringBuilder sb = new StringBuilder(); // 保存结果
        List<Integer> num = new ArrayList<>(); // 原始序列，1,2,3,...,n
        for (int i = 1; i <= n; i++) {
            num.add(i);
        }
        int factorial = 1; // 计算 (n - 1)!
        for (int i = 1; i <= n - 1; i++) {
            factorial *= i;
        }
        k = k - 1; // 简化计算
        for (int i = 1; i < n; i++) {
            if (k == 0) break; // 当 k = 0，表示后面的序列是按原始序列来排的
            int index = k / factorial;
            k %= factorial;
            factorial /= (n - i);
            sb.append(num.get(index));
            num.remove(index);
        }
        for (int i = 0; i < num.size(); i++) { // 当 num 不为空，即 k = 0 导致上面的循环退出时，num 中剩余的元素按原始顺序排即可
            sb.append(num.get(i));
        }
        return sb.toString();
    }

}
