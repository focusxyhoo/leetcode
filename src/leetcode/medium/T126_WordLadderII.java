package medium;

import java.util.ArrayList;
import java.util.List;

/**
 * created with IntelliJ IDEA
 * author      : focusxyhoo
 * date        : 2019-08-06
 * time        : 21:49
 * description : https://leetcode.com/problems/word-ladder-ii/
 */
public class T126_WordLadderII {
    public static void main(String[] args) {

    }

    private static class graph {
        int size;
        String[] v;
        int[][] m;




    }

    public static List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        if (!wordList.contains(endWord)) return new ArrayList<>();
        if (!wordList.contains(beginWord)) wordList.add(beginWord);
        return null;
    }
}
