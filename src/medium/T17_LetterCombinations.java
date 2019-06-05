package medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class T17_LetterCombinations {

    // 匿名内部类的形式，会存在一定问题
    // 课程通过一个数组来存，根据下标来判断
    private static final Map<String, String> myMap = new HashMap<>();

    static {
        myMap.put("2", "abc");
        myMap.put("3", "def");
        myMap.put("4", "ghi");
        myMap.put("5", "jkl");
        myMap.put("6", "mno");
        myMap.put("7", "pqrs");
        myMap.put("8", "tuv");
        myMap.put("9", "wxyz");
    }



    private static List<String> result = new ArrayList<>();

    public static void backTrack(String combination, String nextDigits) {
        if (nextDigits.length() == 0) {
            result.add(combination);
        } else {
            String digit = nextDigits.substring(0, 1);
            String letters = myMap.get(digit);
            for (int i = 0; i < letters.length(); i++) {
                String letter = letters.substring(i, i + 1);
                backTrack(combination + letter, nextDigits.substring(1));
            }
        }
    }

    public static List<String> letterCombinations(String digits) {
        if (digits.length() != 0) {
            backTrack("", digits);
        }
        return result;
    }

    public static void main(String[] args) {
        String digits = "4567";
        System.out.println(letterCombinations(digits));

    }
}
