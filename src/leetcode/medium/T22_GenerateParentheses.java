package leetcode.medium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

/**
 * @author focusxyhoo
 * @date 2019-04-18 09:51
 */
public class T22_GenerateParentheses {


    /**
     * 思路一：暴力法。找出所有的排列组合，然后舍弃非法的结果。
     *
     * @param n
     * @return
     */
    public static List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        generateAll(0, new char[2 * n], result);
        return result;
    }

    // 如何产生所有的排列组合
    // 只根据长度来生成所有的组合
    // 当长度满足之后，判断是否合法；否则继续添加元素
    private static void generateAll(int index, char[] current, List<String> result) {
        if (index == current.length) {
            if (checkValid(current)) {
                result.add(new String(current));
            }
        } else {
            current[index] = '(';
            generateAll(index + 1, current, result);
            current[index] = ')';
            generateAll(index + 1, current, result);
        }
    }

    // 检查所给出的组合是否合法。记 '(' 为 1，')' 为 -1， 当记号 balance < 0 时即返回 false
    // 注意最后还需要根据 balance == 0 来判断是否合法
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

    /**
     * 思路二：回溯。记录正反括号出现的次数，直接生成正确的组合。
     *
     * @param n
     * @return
     */
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
        if (close < open) {
            backtrack(list, str + ")", open, close + 1, max);
        }
    }

    // DP

    /**
     * 动态规划
     *
     * @param n
     * @return
     */
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
        for (String str : generateParenthesis(n)) {
            System.out.println(str);
        }
        System.out.println("------------------------------");
        for (String str : generateParenthesis2(n)) {
            System.out.println(str);
        }
    }
}
