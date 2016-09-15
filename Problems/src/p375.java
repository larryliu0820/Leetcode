/**
 * Created by Valued Customer on 9/15/2016.
 * 375. Guess Number Higher or Lower II
 * We are playing the Guess Game. The game is as follows:

 I pick a number from 1 to n. You have to guess which number I picked.

 Every time you guess wrong, I'll tell you whether the number I picked is higher or lower.

 However, when you guess a particular number x, and you guess wrong, you pay $x. You win the game when you guess the number I picked.

 Example:

 n = 10, I pick 8.

 First round:  You guess 5, I tell you that it's higher. You pay $5.
 Second round: You guess 7, I tell you that it's higher. You pay $7.
 Third round:  You guess 9, I tell you that it's lower. You pay $9.

 Game over. 8 is the number I picked.

 You end up paying $5 + $7 + $9 = $21.
 Given a particular n ≥ 1, find out how much money you need to have to guarantee a win.
 */
public class p375 {
    public int getMoneyAmount(int n) {
        if (n == 1) return 0;
        int[][] memo = new int[n+1][n+1];
        for (int diff = 1; diff < n; diff++) {
            for (int i = 0; i + diff <= n; i++) {
                int j = i + diff;
                memo[i][j] = Integer.MAX_VALUE;
                for (int k = i; k <= j; k++) {
                    memo[i][j] = Math.min(memo[i][j], k +
                    Math.max(k-1>=i?memo[i][k-1]:0,j>=k+1?memo[k+1][j]:0));
                }
            }

        }
        return memo[1][n];
    }
}
