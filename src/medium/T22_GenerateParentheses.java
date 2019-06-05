package medium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

/**
 * @author focusxyhoo
 * @date 2019-04-18 09:51
 */
public class T22_GenerateParentheses {

    // 思路一：给出所有的排列组合，然后找出合法的结果。
    public static List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        Stack<Character> myStack = new Stack<>();



        return null;
    }

    private static String pushParenthesis(Stack<Character> myStack, int i) {
        while (i-- > 0) {
            myStack.push('(');
        }
        StringBuffer sb = new StringBuffer();
        while (!myStack.isEmpty()) {
            char ch = myStack.pop();
            sb.append(ch + ')');
        }

        return null;
    }

    private static boolean checkValid(char[] str) {
        int balance = 0;
        for (char ch : str) {
            if (ch == '(') {
                balance++;
            } else {
                balance--;
            }
            if (balance < 0) {
                return false;
            }
        }
        return (balance == 0);
    }

    // 另一种思路产生所有可能的组合
    public static List<String> generateParenthesis2(int n) {
        List<String> list = new ArrayList<>();
        backtrack(list, "", 0, 0, n);
        return list;
    }

    private static void backtrack(List<String> list, String str, int open, int close, int max) {
        if (str.length() == max * 2) {
            list.add(str);
            return;
        }
        if (open < max) {
            backtrack(list, str + "(", open + 1, close, max);
        }
        if (close < max) {
            backtrack(list, str + ")", open, close + 1, max);
        }
    }

    // DP
    public static List<String> generateParenthesis3(int n) {
        List<List<String>> lists = new ArrayList<>();
        lists.add(Collections.singletonList(""));
        for (int i = 1; i <= n; i++) {
            final List<String> list = new ArrayList<>();
            for (int j = 0; j < i; j++) {
                for (final String first : lists.get(j)) {
                    for (final String second : lists.get(i - 1 - j)) {
                        list.add("(" + first + ")" + second);
                    }
                }
            }
            lists.add(list);
        }
        return lists.get(lists.size() - 1);
    }

    public static void main(String[] args) {
        int n = 3;
        for (String str : generateParenthesis2(n)) {
            if (checkValid(str.toCharArray())) {
                System.out.println(str);

            }
        }
        System.out.println("------------------------------");
        for (String str : generateParenthesis3(4)) {
            System.out.println(str);
        }
    }
}
