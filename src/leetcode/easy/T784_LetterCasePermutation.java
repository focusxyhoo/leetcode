package leetcode.easy;

import java.util.LinkedList;
import java.util.List;

/**
 * created with IntelliJ IDEA
 * author      : focusxyhoo
 * date        : 2019-06-21
 * time        : 13:28
 * description : 给出一个字符串，只有字母和数字组成。将其中的字母进行大小写变换，给出所有的可能组合。
 * 时间复杂度：O(n*2^l)，其中，l 是字符串中字母的个数。
 * 空间复杂度：O(n)+O(n*2^l)
 */
public class T784_LetterCasePermutation {

    public static void main(String[] args) {
        String s = "a1b2c";
        for (String str : letterCasePermutation(s)) {
            System.out.println(str);
        }
    }

    public static List<String> letterCasePermutation(String s) {
        List<String> ans = new LinkedList<>();
        dfs(s.toCharArray(), 0, ans);
        return ans;
    }

    public static void dfs(char[] ch, int i, List<String> ans) {
        if (i == ch.length) {
            ans.add(new String(ch)); // 字符数组转换为字符串的方法。
            return;
        }
        dfs(ch, i + 1, ans);
        if (Character.isDigit(ch[i])) { // 判断一个字符是否是数字，是否是字母的静态方法。
            return;
        }
        ch[i] ^= (1 << 5); // 如何将一个字母进行大小写转换。
        dfs(ch, i + 1, ans);
        ch[i] ^= (1 << 5);
    }


}
