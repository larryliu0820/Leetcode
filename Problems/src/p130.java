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
        if (board == null || board.length < 3 || board[0].length < 3) return;
        int[] rows = new int[]{0, board.length - 1};
        int[] cols = new int[]{0, board[0].length - 1};
        for (int i : rows) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == 'O') {
                    dfs(board, i, j);
                }
            }
        }

        for (int i = 1; i < board.length - 1; i++) {
            for (int j: cols) {
                if (board[i][j] == 'O') {
                    dfs(board, i, j);
                }
            }
        }

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if(board[i][j]=='1') board[i][j] = 'O';
                else if(board[i][j]=='O') board[i][j] = 'X';
            }
        }

    }


    public void dfs(char[][] board, int row, int col) {
        board[row][col] = '1';
        // up
        if (row > 0 && board[row-1][col] == 'O' ) dfs(board,  row-1, col);
        // left
        if (col > 0 && board[row][col-1] == 'O') dfs(board,  row, col-1);
        // down
        if (row < board.length - 1 && board[row+1][col] == 'O') dfs(board,  row+1, col);
        // right
        if (col < board[0].length - 1 && board[row][col+1] == 'O') dfs(board,  row, col+1);

    }

    public void bfs(char[][] board, boolean[][] visited, List<int[]> neighbors) {
        boolean isClosed = true;
        int curr = 0;
        while (curr < neighbors.size()) {
            int row = neighbors.get(curr)[0];
            int col = neighbors.get(curr)[1];
            visited[row][col] = true;

            if (row == 0 || row == board.length - 1 || col == 0 || col == board[0].length - 1) {
                isClosed = false;
            }
            // up
            if (row > 0 && board[row-1][col] == 'O') {

                if (!visited[row-1][col]) {
                    int[] up = new int[]{row - 1, col};
                    neighbors.add(up);
                }
            }

            // left
            if (col > 0 && board[row][col-1] == 'O') {
                if (!visited[row][col-1]) {
                    int[] left = new int[]{row, col-1};
                    neighbors.add(left);
                }

            }

            // down
            if ( row < board.length - 1 && board[row+1][col] == 'O') {
                if (!visited[row+1][col]) {
                    int[] down = new int[]{row + 1,col};
                    neighbors.add(down);
                }

            }

            // right
            if ( col < board[0].length - 1 && board[row][col+1] == 'O') {
                if (!visited[row][col+1]) {
                    int[] right = new int[]{row, col + 1};
                    neighbors.add(right);
                }

            }
            curr++;
        }
        if (isClosed) {
            for (int[] ind : neighbors) {
                board[ind[0]][ind[1]] = 'X';
            }
        }
    }

    public static void main(String[] args) {
        p130 sol = new p130();

        String[] input = new String[]{"XOOOOOOOOOOOOOOOOOOO","OXOOOOXOOOOOOOOOOOXX","OOOOOOOOXOOOOOOOOOOX","OOXOOOOOOOOOOOOOOOXO","OOOOOXOOOOXOOOOOXOOX","XOOOXOOOOOXOXOXOXOXO","OOOOXOOXOOOOOXOOXOOO","XOOOXXXOXOOOOXXOXOOO","OOOOOXXXXOOOOXOOXOOO","XOOOOXOOOOOOXXOOXOOX","OOOOOOOOOOXOOXOOOXOX","OOOOXOXOOXXOOOOOXOOO","XXOOOOOXOOOOOOOOOOOO","OXOXOOOXOXOOOXOXOXOO","OOXOOOOOOOXOOOOOXOXO","XXOOOOOOOOXOXXOOOXOO","OOXOOOOOOOXOOXOXOXOO","OOOXOOOOOXXXOOXOOOXO","OOOOOOOOOOOOOOOOOOOO","XOOOOXOOOXXOOXOXOXOO"};
        char[][] board = new char[input.length][];
        for (int i = 0; i < input.length; i ++) {
            board[i] = input[i].toCharArray();
        }
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.print("\n");
        }
        System.out.print("\n");

        sol.solve(board);
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.print("\n");
        }

    }
}
