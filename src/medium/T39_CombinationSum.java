package medium;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author focusxyhoo
 * @date 2019-05-06 14:21
 */
public class T39_CombinationSum {

    /**
     *
     * @param candidates
     * @param target
     * @return
     */

    public static List<List<Integer>> lists = new LinkedList<>();

    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        if (candidates.length == 0) {
            return null;
        }

        int len = candidates.length;
        int cur = len - 1;
        Arrays.sort(candidates);
        while (cur >= 0) {
            List<Integer> list = new LinkedList<>();
            if (candidates[cur] > target) {
                cur--;
                continue;
            } else if (candidates[cur] == target) {
                list.add(candidates[cur]);
                lists.add(list);
            } else {

            }
        }

        return null;
    }

    public static void main(String[] args) {

    }
}
