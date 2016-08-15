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
        if (grid == null || grid.length == 0) return 0;
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        int num = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (!visited[i][j] && grid[i][j] == '1') {
                    dfs(grid, visited, i, j);
                    num++;
                }
            }
        }
        return num;
    }

    public void dfs(char[][] grid, boolean[][] visited, int row, int col) {
        if (visited[row][col]) return;
        visited[row][col] = true;
        if (row > 0 && grid[row-1][col] == '1') dfs(grid, visited, row-1, col);
        if (row < grid.length-1 && grid[row+1][col] == '1') dfs(grid, visited, row+1, col);
        if (col > 0 && grid[row][col-1] == '1') dfs(grid, visited, row, col-1);
        if (col < grid[0].length-1 && grid[row][col+1] == '1') dfs(grid, visited, row, col+1);
    }
}
