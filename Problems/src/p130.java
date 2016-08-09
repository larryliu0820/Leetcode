import java.util.ArrayList;
import java.util.List;

/**
 * Created by Valued Customer on 8/7/2016.
 * 130. Surrounded Regions
 * Given a 2D board containing 'X' and 'O' (the letter O), capture all regions surrounded by 'X'.

 A region is captured by flipping all 'O's into 'X's in that surrounded region.

 For example,
 X X X X
 X O O X
 X X O X
 X O X X
 After running your function, the board should be:

 X X X X
 X X X X
 X X X X
 X O X X
 */
public class p130 {
    public void solve(char[][] board) {
        if (board == null || board.length == 0) return;
        boolean[][] visited = new boolean[board.length][board[0].length];

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == 'O' && !visited[i][j]) {
                    List<List<Integer>> neighbors = new ArrayList<>();
                    List<Integer> root = new ArrayList<>();
                    root.add(i);
                    root.add(j);
                    neighbors.add(root);
                    bfs(board, visited, neighbors);
                }
            }
        }
    }

    public boolean dfs(char[][] board, boolean[][] visited, int[] index) {
        int row = index[0];
        int col = index[1];
        if (visited[row][col]) return true;
        visited[row][col] = true;
        // up

        if (row == 0 || row == board.length - 1) return false;
        if (col == 0 || col == board[0].length - 1) return false;
        if (board[row-1][col] == 'O' ) {

            index[0]--;
            if (!dfs(board, visited, index)) return false;
            index[0]++;
        }

        // left

        if (board[row][col-1] == 'O') {
            index[1]--;
            if (!dfs(board, visited, index)) return false;
            index[1]++;
        }

        // down

        if (board[row+1][col] == 'O') {
            index[0]++;
            if (!dfs(board, visited, index)) return false;
            index[0]--;
        }

        // right

        if (board[row][col+1] == 'O') {
            index[1]++;
            if (!dfs(board, visited, index)) return false;
            index[1]--;
        }

        board[row][col] = 'X';
        return true;
    }

    public void bfs(char[][] board, boolean[][] visited, List<List<Integer>> neighbors) {
        boolean isClosed = true;
        int curr = 0;
        while (curr < neighbors.size()) {
            int row = neighbors.get(curr).get(0);
            int col = neighbors.get(curr).get(1);
            visited[row][col] = true;

            if (row == 0 || row == board.length - 1 || col == 0 || col == board[0].length - 1) {
                isClosed = false;
            }
            // up
            if (row > 0 && board[row-1][col] == 'O') {

                if (visited[row-1][col]) isClosed = false;
                else {
                    List<Integer> up = new ArrayList<>();
                    up.add(row - 1);
                    up.add(col);
                    neighbors.add(up);
                }
            }

            // left
            if (col > 0 && board[row][col-1] == 'O') {
                if (visited[row][col-1]) isClosed = false;
                else {
                    List<Integer> left = new ArrayList<>();
                    left.add(row);
                    left.add(col - 1);
                    neighbors.add(left);
                }

            }

            // down
            if ( row < board.length - 1 && board[row+1][col] == 'O') {
                if (visited[row+1][col]) isClosed = false;
                else {
                    List<Integer> down = new ArrayList<>();
                    down.add(row + 1);
                    down.add(col);
                    neighbors.add(down);
                }

            }

            // right
            if ( col < board[0].length - 1 && board[row][col+1] == 'O') {
                if (visited[row][col+1] ) isClosed = false;
                else {
                    List<Integer> right = new ArrayList<>();
                    right.add(row);
                    right.add(col + 1);
                    neighbors.add(right);
                }

            }
            curr++;
        }
        if (isClosed) {
            for (List<Integer> ind : neighbors) {
                board[ind.get(0)][ind.get(1)] = 'X';
            }
        }
    }
    public static void main(String[] args) {
        p130 sol = new p130();
        char[][] board = new char[9][];
        board[0] = "OXOOOOOOO".toCharArray();
        board[1] = "OOOXOOOOX".toCharArray();
        board[2] = "OXOXOOOOX".toCharArray();
        board[3] = "OOOOXOOOO".toCharArray();
        board[4] = "XOOOOOOOX".toCharArray();
        board[5] = "XXOOXOXOX".toCharArray();
        board[6] = "OOOXOOOOO".toCharArray();
        board[7] = "OOOXOOOOO".toCharArray();
        board[8] = "OOOOOXXOO".toCharArray();
        sol.solve(board);
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.print("\n");
        }

    }
}
