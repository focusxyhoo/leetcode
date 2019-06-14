package hard;

import java.util.ArrayList;
import java.util.List;

/**
 * created with IntelliJ IDEA
 * author      : focusxyhoo
 * date        : 2019-06-14
 * time        : 08:49
 * description : 同 T52，区别在于本题要求返回所有可能的结果，而不是总数目。
 */
public class T51_NQueens {


    public static void main(String[] args) {

        System.out.println(solveNQueens(4));
    }

    /**
     * 用来存放结果的链表
     */
    public static List<List<String>> result = new ArrayList<>();


    public static List<List<String>> solveNQueens(int n) {

        backtrack(1, new int[n + 1], n);
        return result;
    }

    /**
     * 同 T52。
     *
     * @param index
     * @param position
     * @param n
     */
    public static void backtrack(int index, int[] position, int n) {

        if (index > n) {
            result.add(generateResult(position));
        } else {
            for (int i = 1; i <= n; i++) {
                position[index] = i;
                if (T52_NQueensII.isValid(position, index)) {
                    backtrack(index + 1, position, n);
                }
            }
        }
    }


    /**
     * 这个方法用来将 int[] position 转换成 List<String> result。
     *
     * @param position
     * @return
     */
    public static List<String> generateResult(int[] position) {

        List<String> resut = new ArrayList<>();
        for (int i = 1; i < position.length; i++) {
            char[] row = new char[position.length];
            for (int j = 0; j < row.length; j++) {
                row[j] = '.';
            }
            row[position[i]] = 'Q';
            resut.add(new String(row).substring(1));
        }
//        System.out.println(resut);
        return resut;
    }
}
