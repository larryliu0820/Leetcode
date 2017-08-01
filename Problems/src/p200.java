import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by Valued Customer on 8/13/2016.
 * 200. Number of Islands
 * Given a 2d grid map of '1's (land) and '0's (water), count the number of islands. An island is surrounded by water and
 * is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.

 Example 1:

 11110
 11010
 11000
 00000
 Answer: 1

 Example 2:

 11000
 11000
 00100
 00011
 Answer: 3
 */
public class p200 {
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) return 0;
        int m = grid.length, n = grid[0].length;
        boolean[][] visited = new boolean[m][n];
        Queue<int[]> queue = new LinkedList<>();
        int count = 0;
        int[][] inc = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '0' || visited[i][j]) continue;
                if (queue.isEmpty()) {
                    visited[i][j] = true;
                    queue.offer(new int[]{i,j});
                }
                while (!queue.isEmpty()) {
                    int[] curr = queue.poll();
                    for (int[] delta : inc) {
                        int nrow = curr[0] + delta[0];
                        int ncol = curr[1] + delta[1];
                        if (isValid(m, n, nrow, ncol) &&
                                (!visited[nrow][ncol]) &&
                                grid[nrow][ncol] == '1') {
                            visited[nrow][ncol] = true;
                            queue.offer(new int[]{nrow, ncol});
                        }
                    }
                }
                count++;
            }
        }
        return count;
    }

    private boolean isValid(int m, int n, int i, int j) {
        return i >= 0 && i < m && j >= 0 && j < n;
    }
}
