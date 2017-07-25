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
        return 0;
    }
}
