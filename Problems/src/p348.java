/**
 * Created by larryliu on 7/22/17.
 * 348. Design Tic-Tac-Toe
 *
 */
public class p348 {
    /** Initialize your data structure here. */
    int[][] playground;
    public p348(int n) {
        playground = new int[n][n];
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
        playground[row][col] = player;
        for (char mode : new char[]{'-', '|', '/', '\\'}) {
            if (check(row, col, player, mode)) return player;
        }
        return 0;
    }

    private boolean check(int row, int col, int player, char mode) {
        if (mode == '-') {
            for (int i = 0; i < playground[row].length; i++)
                if (playground[row][i] != player) return false;
        } else if (mode == '|') {
            for (int i = 0; i < playground.length; i++)
                if (playground[i][col] != player) return false;
        } else if (mode == '/' && row + col == playground.length -1) {
            for (int i = 0; i < playground.length; i++)
                if (playground[i][playground.length-1-i] != player) return false;
        } else if (mode == '\\' && row == col) {
            for (int i = 0; i < playground.length; i++)
                if (playground[i][i] != player) return false;
        }
        return true;
    }
}
