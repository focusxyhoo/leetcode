package examination;

import java.util.*;

/**
 * created with IntelliJ IDEA
 * author      : focusxyhoo
 * date        : 2019/9/16
 * time        : 21:26
 * description : pass rate 1.0
 */
public class KuaiShou02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        Map<Integer, String> map = new HashMap<>();
        map.put(1, "");
        map.put(2, "abc");
        map.put(3, "def");
        map.put(4, "ghi");
        map.put(5, "jkl");
        map.put(6, "mno");
        map.put(7, "pqrs");
        map.put(8, "tuv");
        map.put(9, "wxyz");
        List<String> ans = new ArrayList<>();
        backtrack(map, ans, new ArrayList<>(), s, 0);
        StringBuilder result = new StringBuilder();
        result.append('[');
        for (int i = 0; i < ans.size(); i++) {
            result.append(ans.get(i));
            if (i != ans.size() - 1) result.append(", ");
        }
        result.append(']');
        System.out.println(result.toString());
    }

    private static void backtrack(Map<Integer, String> map, List<String> ans, List<Character> tempList, String s, int i) {
        if (tempList.size() == s.length()) {
            StringBuilder temp = new StringBuilder();
            for (Character character : tempList) {
                temp.append(character);
            }
            ans.add(temp.toString());
        } else {
            int currIndex = s.charAt(i) - '0';
            String currString = map.get(currIndex);
            for (int j = 0; j < currString.length(); j++) {
                tempList.add(currString.charAt(j));
                backtrack(map, ans, tempList, s, i + 1);
                tempList.remove(tempList.size() - 1);
            }
        }
    }
}
