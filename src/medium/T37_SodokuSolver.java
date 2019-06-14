package medium;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * created with IntelliJ IDEA
 * author      : focusxyhoo
 * date        : 2019-06-14
 * time        : 09:40
 * description : 给出一个合法的数独棋盘，给出其解。
 */
public class T37_SodokuSolver {

    public static void main(String[] args) {

        char[][] board = {
                {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}};


        // 检查各方法是否正确
        char[][] subgrid = getSubgrid(board, 8, 4);
        for (int i = 0; i < subgrid.length; i++) {
            System.out.println(Arrays.toString(subgrid[i]));
        }
        System.out.println();
        System.out.println(Arrays.toString(getColumn(board, 3)));
        System.out.println();


        solveSodoku(board);

        for (int i = 0; i < board.length; i++)
            System.out.println(Arrays.toString(board[i]));

    }

    /**
     * 回溯法。
     *
     * @param board
     */
    public static void solveSodoku(char[][] board) {

        backtrack(board, 0, 0);
    }


    public static void backtrack(char[][] board, int row, int col) {

        if (row >= 9 || col >= 9) return;

        if (board[row][col] != '.') {
            backtrack(board, row, col + 1);
            backtrack(board, row + 1, 0);
        } else {
            for (char c = '1'; c <= '9'; c++) {
                board[row][col] = c;
                if (isValid(board, row, col)) {
                    backtrack(board, row, col + 1);
                    backtrack(board, row + 1, 0);
                }
            }
        }
    }

    public static boolean isValid(char[][] board, int row, int col) {
        if (isLineValid(board[row]) && isLineValid(getColumn(board, col)) && isSubgridValid(getSubgrid(board, row, col))) {
            return true;
        }
        return false;
    }


    /**
     * 判断某行 / 列 是否合法。
     * 根据往 set.add() 的返回结果来判断。
     *
     * @param line
     * @return
     */
    public static boolean isLineValid(char[] line) {
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < line.length; i++) {
            if (line[i] != '.') {
                if (!set.add(line[i]))
                    return false;
            }
        }
        return true;
    }

    public static boolean isSubgridValid(char[][] subgrid) {
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < subgrid.length; i++) {
            for (int j = 0; j < subgrid[i].length; j++) {
                if (subgrid[i][j] != '.') {
                    if (!set.add(subgrid[i][j])) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    /**
     * 返回 board 的列。
     *
     * @param board
     * @param col
     * @return
     */
    public static char[] getColumn(char[][] board, int col) {
        char[] column = new char[board.length];
        for (int i = 0; i < column.length; i++) {
            column[i] = board[i][col];
        }
        return column;
    }

    /**
     * 根据当前位置获取其所在的 3x3 子矩阵。
     *
     * @param board
     * @param row
     * @param col
     * @return
     */
    public static char[][] getSubgrid(char[][] board, int row, int col) {

        char[][] result = new char[3][3];
        int iRow = row / 3;
        int iCol = col / 3;

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                result[i][j] = board[3 * iRow + i][3 * iCol + j];
            }
        }
        return result;
    }
}
