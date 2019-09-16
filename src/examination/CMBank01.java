package examination;

import java.util.*;

/**
 * created with IntelliJ IDEA
 * author      : focusxyhoo
 * date        : 2019/9/6
 * time        : 14:55
 * description :
 */

public class CMBank01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        char[] chars = {'A', 'B', 'C'};
        List<List<Character>> ans = new ArrayList<>();
        backtrack(ans, new ArrayList<>(), chars, n);
        System.out.println(ans.size());
        for (List<Character> an : ans) {
            for (Character character : an) {
                System.out.print(character);
            }
            System.out.println();
        }
    }

    private static void backtrack(List<List<Character>> result, List<Character> tempList, char[] chars, int n) {
        if (tempList.size() == n) {
            if (isLegal(tempList)) result.add(new ArrayList<>(tempList));
        } else {
            for (int i = 0; i < chars.length; i++) {
                tempList.add(chars[i]);
                backtrack(result, tempList, chars, n);
                tempList.remove(tempList.size() - 1);
            }
        }
    }

    private static boolean isLegal(List<Character> s) {
        int countB = 0;
        int countC = 0;
        for (int i = 0; i < s.size(); i++) {
            char temp = s.get(i);
            if (temp == 'C') {
                countC++;
                if (countC > 1) return false;
            }
            if (temp == 'B') {
                if (i - 1 < 0 || s.get(i - 1) != 'B') countB = 0;
                countB++;
                if (countB > 2) return false;
            }
        }
        return true;
    }
}
