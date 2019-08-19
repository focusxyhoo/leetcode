package leetcode.medium;

import java.util.LinkedList;
import java.util.List;

/**
 * created with IntelliJ IDEA
 * author      : focusxyhoo
 * date        : 2019-06-26
 * time        : 15:16
 * description :
 */
public class T139_WordBreak {

    public static boolean wordBreak(String s, List<String> wordDict) {

        int i = 0;
        while (i < s.length()) {
            for (String word : wordDict) {
                if (s.substring(i, i + word.length()).equals(word)) {
                    i = i + word.length();
                    break;
                }
            }
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        String s = "leetcode";
        List<String> wordDict = new LinkedList<>();
        wordDict.add("leet");
        wordDict.add("code");
        System.out.println(wordBreak(s, wordDict));
    }
}
