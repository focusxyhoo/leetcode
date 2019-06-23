package hard;

import java.util.Arrays;

/**
 * created with IntelliJ IDEA
 * author      : focusxyhoo
 * date        : 2019-06-23
 * time        : 20:03
 * description : https://leetcode.com/problems/dungeon-game/
 * dp.
 */
public class T174_DungeonGame {
    public static void main(String[] args) {

        int[][] nums = {{-2, -3, 3},
                {-5, -10, 1},
                {10, 30, -5}};


        System.out.println(Arrays.deepToString(calculateMinimumHP(nums)));
        System.out.println(calculateMinimumHP(nums)[0][0]);
    }

    public static int[][] calculateMinimumHP(int[][] dungeon) {

        int m = dungeon.length;
        int n = dungeon[0].length;

        int[][] hp = new int[m + 1][n + 1];
//        int[] hello = new int[n + 1];
//        Arrays.fill(hello, Integer.MAX_VALUE);
//        Arrays.fill(hp, hello);

        // 对 dp 数组初始化
        for (int i = 0; i <= m; i++) {
            Arrays.fill(hp[i], Integer.MAX_VALUE);
        }
        // 注意从公主（右下角）出来的两个位置的值必须是 1
        hp[m][n - 1] = hp[m - 1][n] = 1;

        for (int y = m - 1; y >= 0; y--) {
            for (int x = n - 1; x >= 0; x--) {
                hp[y][x] = Math.max(1, Math.min(hp[y + 1][x], hp[y][x + 1]) - dungeon[y][x]);
            }
        }
        return hp;


    }
}
