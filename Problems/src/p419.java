/**
 * Created by Valued Customer on 7/21/2017.
 * 419. Battleships in a Board
 *
 *
 */
public class p419 {
    public int countBattleships(char[][] board) {
        if (board == null || board.length == 0 || board[0].length == 0) return 0;
        int count = 0;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == 'X') {
                    if ((i == board.length - 1 || board[i+1][j] == '.') &&
                            (j == board[0].length - 1 || board[i][j+1] == '.'))
                        count++;
                }
            }
        }
        return count;
    }
}
