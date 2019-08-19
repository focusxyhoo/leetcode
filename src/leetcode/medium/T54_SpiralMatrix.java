package leetcode.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * created with IntelliJ IDEA
 * author      : focusxyhoo
 * date        : 2019-08-13
 * time        : 20:36
 * description : https://leetcode.com/problems/spiral-matrix/
 * 这道题我不知道归到哪个题型中去。
 * 题目意思是螺旋式打印一个二维数组的所有元素。
 * 先放着，这种类型的题不感兴趣。
 *
 */
public class T54_SpiralMatrix {

    public static List<Integer> spiralOrder(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        List<Integer> result = new ArrayList<>();
        int indexX = 0, indexY = 0;
        for (int i = indexX; i < n; i++) {
            result.add(matrix[i][indexY]);
        }


        return result;
    }
}
