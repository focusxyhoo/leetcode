package leetcode.medium;

import java.util.Deque;
import java.util.LinkedList;

/**
 * created with IntelliJ IDEA
 * author      : focusxyhoo
 * date        : 2019/9/16
 * time        : 10:57
 * description :
 */
public class T547_FriendCircles {
    public static void main(String[] args) {

    }

    /**
     * dfs: 遍历所有节点，对每一个节点，将其好友全部标记为已访问（包括自己），然后统计被访问的节点个数即可。
     * Runtime: 1 ms, faster than 100.00% of Java online submissions for Friend Circles.
     * Memory Usage: 44.1 MB, less than 48.00% of Java online submissions for Friend Circles.
     *
     * @param M
     * @return
     */
    public static int findCircleNum(int[][] M) {
        int count = 0;
        int[] visited = new int[M.length];
        for (int i = 0; i < M.length; i++) {
            if (visited[i] == 0) {
                count++;
                dfs(M, visited, i);
            }
        }
        return count;
    }

    private static void dfs(int[][] M, int[] visited, int i) {
        visited[i] = 1;
        for (int j = 0; j < M.length; j++) {
            if (M[i][j] == 1 && visited[j] == 0) {
                dfs(M, visited, j);
            }
        }
    }

    /**
     * bfs
     *
     * @param M
     * @return
     */
    public static int findCircleNum2(int[][] M) {
        int[] visited = new int[M.length];
        int count = 0;
        for (int i = 0; i < M.length; i++) {
            if (visited[i] == 0) {
                count++;
                bfs(M, visited, i);
            }
        }
        return count;
    }

    private static Deque<Integer> queue = new LinkedList<>();

    private static void bfs(int[][] M, int[] visited, int i) {
        queue.offer(i);
        visited[i] = 1;
        while (!queue.isEmpty()) {
            int node = queue.poll();
            for (int j = 0; j < M.length; j++) {
                if (visited[j] == 0 && M[node][j] == 1) {
                    queue.offer(j);
                    visited[j] = 1;
                }
            }
        }
    }


}

