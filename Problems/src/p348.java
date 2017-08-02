/**
 * Created by larryliu on 7/22/17.
 * 348. Design Tic-Tac-Toe
 *
 */
public class p348 {
    /** Initialize your data structure here. */
    int[][] board;
    public p348(int n) {
        board = new int[n][n];
    }

    /** Player {player} makes a move at ({row}, {col}).
     @param row The row of the board.
     @param col The column of the board.
     @param player The player, can be either 1 or 2.
     @return The current winning condition, can be either:
     0: No one wins.
     1: Player 1 wins.
     2: Player 2 wins. */
    public int move(int row, int col, int player) {
        char[] directions = new char[]{'-', '|', '\\', '/'};
        board[row][col] = player;
        for (char dir : directions) if (check(row, col, player, dir)) return player;
        return 0;
    }

    private boolean check(int row, int col, int player, char direction) {
        switch (direction) {
            case '-': {
                for (int i = 0; i < board.length; i++) if (board[row][i] != player) return false;
                return true;
            }
            case '|': {
                for (int i = 0; i < board.length; i++) if (board[i][col] != player) return false;
                return true;
            }
            case '\\': {
                if (row != col) return false;
                for (int i = 0; i < board.length; i++) if (board[i][i] != player) return false;
                return true;
            }
            case '/': {
                if (row+col != board.length - 1) return false;
                for (int i = 0; i < board.length; i++) if (board[i][board.length-i-1] != player) return false;
                return true;
            }
        }
        return false;
    }
}
