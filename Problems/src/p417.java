import java.util.ArrayList;
import java.util.List;

/**
 * Created by Valued Customer on 7/19/2017.
 * 417. Pacific Atlantic Water Flow
 */
public class p417 {
    public List<int[]> pacificAtlantic(int[][] matrix) {
        List<int[]> result = new ArrayList<>();
        if (matrix == null || matrix.length == 0) return result;
        int m = matrix.length, n = matrix[0].length;
        int[][] memo = new int[m][n];
        for (int i = 0; i < m; i++) {
            dfs(matrix, memo, i, 0, Integer.MIN_VALUE, 1);
            dfs(matrix, memo, i, n-1, Integer.MIN_VALUE, 2);
        }
        for (int j = 0; j < n; j++) {
            dfs(matrix, memo, 0, j, Integer.MIN_VALUE, 1);
            dfs(matrix, memo, 0, m-1, Integer.MIN_VALUE, 2);
        }
        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++)
                if (memo[i][j] == 3) result.add(new int[]{i,j});
        return result;
    }

    private void dfs(int[][] matrix, int[][] memo, int col, int row, int pre, int preval) {
        if (col < 0 || row < 0 || col >= memo.length || row >= memo[0].length) return;
        if (pre > matrix[col][row] || (memo[col][row] & preval) == preval) return;
        int[][] inc = new int[][]{{0, -1}, {0, 1}, {-1, 0}, {1, 0}};
        memo[col][row] |= preval;
        for (int[] i :inc) {
            dfs(matrix, memo, col + i[0], row + i[1], matrix[col][row], memo[col][row]);
        }
    }

    public static void main(String[] args) {
        int[][] matrix = new int[][]{
                {1,2,2,3,5},
                {3,2,3,4,4},
                {2,4,5,3,1},
                {6,7,1,4,5},
                {5,1,1,2,4}
        };
        p417 sol = new p417();
        sol.pacificAtlantic(matrix);
    }
}
