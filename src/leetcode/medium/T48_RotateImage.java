package leetcode.medium;

/**
 * created with IntelliJ IDEA
 * author      : focusxyhoo
 * date        : 2019-08-05
 * time        : 20:15
 * description :
 */
public class T48_RotateImage {
    public static void main(String[] args) {
        int[][] matrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        rotate(matrix);
    }

    public static void rotate(int[][] matrix) {
        int n = matrix.length;

        for (int i = 0; i < n; i++) {
            for (int j = i; j < n - i; j++) {
                if (j != n - 1 - i) {
                    int temp = matrix[i][j];
                    matrix[i][j] = matrix[n - 1 - j][i];
                    matrix[n - 1 - j][i] = matrix[n - 1 - i][n - 1 - j];
                    matrix[n - 1 - i][n - 1 - j] = matrix[j][n - 1 - i];
                    matrix[j][n - 1 - i] = temp;
                }
            }
        }

        // print
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(matrix[i][j]);
                if (j != n - 1) System.out.print(" ");
            }
            System.out.println();
        }
    }
}
