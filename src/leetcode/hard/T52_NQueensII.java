package hard;

/**
 * created with IntelliJ IDEA
 * author      : focusxyhoo
 * date        : 2019-06-13
 * time        : 17:24
 * description : N 皇后问题。给定 N 的值，返回所有可能结果的数目。
 */
public class T52_NQueensII {
    public static void main(String[] args) {
        System.out.println(totalNQueens(8));
    }

    // 定义字段 count 来统计总数目
    public static int count = 0;
    /**
     * 包装
     *
     * @param n
     * @return
     */
    public static int totalNQueens(int n) {
        backtrack(1, n, new int[n + 1]);
        return count;
    }

    /**
     * 回溯。
     *
     * @param index 当前要放置皇后的行，需要确定 position[index] 的值，使不发生冲突
     * @param n 皇后的个数 / 棋盘的大小
     * @param position position[i] 的含义：第 i 行的 position[i] 列放置了一个皇后
     */
    public static void backtrack(int index, int n, int[] position) {
        // 当所有皇后均放置完后
        if (index > n) {
            count++; // 总数目加一
            for (int i = 1; i <= n; i++) {
                System.out.print(position[i] + ", ");
            }
            System.out.println();
        } else {
            // 如何在当前行放置皇后？
            // 从 1 到 n 遍历，依次判断是否合法
            for (int i = 1; i <= n; i++) {
                position[index] = i;
                if (isValid(position, index)) {
                    // 若合法，继续考虑下一行的皇后的位置
                    backtrack(index + 1, n, position);
                }
            }
        }
    }

    /**
     * 判断当前位置 position[index] 是否与位置 position[1 ~ index] 相冲突
     *
     * @param position
     * @param index
     * @return
     */
    public static boolean isValid(int[] position, int index) {
        for (int i = 1; i < index; i++) {
            // 检测冲突的条件
            // 当 |index - i| == |position[index] - position[i]| 或者
            // position[i] == position[index] 时，认为位置冲突
            if (Math.abs(index - i) == Math.abs(position[index] - position[i]) || position[index] == position[i]) {
                return false;
            }
        }
        return true;
    }
}
