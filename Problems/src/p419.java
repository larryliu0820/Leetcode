/**
 * Created by Valued Customer on 7/21/2017.
 * 419. Battleships in a Board
 *
 *
 */
public class p419 {
    public int countBattleships(char[][] board) {
        if (board == null || board.length == 0 || board[0].length == 0) return 0;
        int m = board.length, n = board[0].length;
        int count = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == '.') continue;
                int shape = 0;
                if (j-1 < 0 || board[i][j-1] == '.') shape |= 1;
                if (i-1 < 0 || board[i-1][j] == '.') shape |= 2;
                if (shape == 3) count++;
            }
        }
        return count;
    }
}
