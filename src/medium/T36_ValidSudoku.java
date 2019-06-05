package medium;

import java.util.HashSet;

/**
 * @author focusxyhoo
 * @date 2019-05-06 13:13
 */
public class T36_ValidSudoku {

    /**
     * 检查给定的一个 9x9 的二维数组是否构成一个合法的数独题。
     * 数独的规则很简单，每行每列每 3x3 小格都恰好包含 1-9，不能重复。
     * 空格的位置用'.'表示。
     * 参考其他方法。
     * @param board
     * @return
     */
    public static boolean isValidSudoku(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            if (!isRowValid(board[i])) {
                return false;
            }
        }
        for (int j = 0; j < board.length; j++) {
            char[] column = new char[board.length];
            for (int i = 0; i < board.length; i++) {
                column[i] = board[i][j];
            }
            if (!isRowValid(column)) {
                return false;
            }
        }
        for (int i = 1; i <= 3; i++) {
            for (int j = 1; j <= 3; j++) {
                char[][] subgrid = new char[3][3];
                for (int isub = 0; isub < 3; isub++) {
                    for (int jsub = 0; jsub < 3; jsub++) {
                        subgrid[isub][jsub] = board[3 * i - (3 - isub)][3 * j - (3 - jsub)];
//                        System.out.print(subgrid[isub][jsub]);
                    }
//                    System.out.println("\n");
                }
                if (!isSubgridValid(subgrid)) {
                    return false;
                }
            }
        }
        return true;
    }

    // 总共有三种不同的情形，那么可以根据每种情形写一个判断方法。
    public static boolean isRowValid(char[] row) {
        HashSet<Character> mySet = new HashSet<>();
        int count = 0;
        for (int i = 0; i < row.length; i++) {
            if (row[i] != '.') {
                mySet.add(row[i]);
            } else {
                count++;
            }
        }
        if ((mySet.size() + count) != row.length) {
            return false;
        } else {
            return true;
        }

    }

    public static boolean isSubgridValid(char[][] subgrid) {
        HashSet<Character> mySet = new HashSet<>();
        int count = 0;
        for (int i = 0; i < subgrid.length; i++) {
            for (int j = 0; j < subgrid[i].length; j++) {
                if (subgrid[i][j] != '.') {
                    mySet.add(subgrid[i][j]);
                } else {
                    count++;
                }
            }
        }
        if ((mySet.size() + count) != subgrid.length * subgrid[0].length) {
            return false;
        } else {
            return true;
        }
    }

    public static void main(String[] args) {
//        char[] row = {'5', '3', '1', '2', '7', '4', '9', '6', '8'};
//        char[][] subgrid = {{'.', '1', '.'},
//                            {'.', '.', '.'},
//                            {'.', '.', '1'}};
        char[][] board = {{'.', '.', '.', '.', '5', '.', '.', '1', '.'},
                          {'.', '4', '.', '3', '.', '.', '.', '.', '.'},
                          {'.', '.', '.', '.', '.', '3', '.', '.', '1'},
                          {'8', '.', '.', '.', '.', '.', '.', '2', '.'},
                          {'.', '.', '2', '.', '7', '.', '.', '.', '.'},
                          {'.', '1', '5', '.', '.', '.', '.', '.', '.'},
                          {'.', '.', '.', '.', '.', '2', '.', '.', '.'},
                          {'.', '2', '.', '9', '.', '.', '.', '.', '.'},
                          {'.', '.', '4', '.', '.', '.', '.', '.', '.'}};

//        System.out.println(isRowValid(row));
//        System.out.println(isSubgridValid(subgrid));
        System.out.println(isValidSudoku(board));

    }
}
