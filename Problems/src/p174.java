/**
 * Created by Valued Customer on 7/27/2017.
 * 174. Dungeon Game
 */
public class p174 {
    public int calculateMinimumHP(int[][] dungeon) {
        if (dungeon == null || dungeon.length == 0 || dungeon[0].length == 0) return 0;
        int m = dungeon.length, n = dungeon[0].length;
        int[][] dp = new int[m][n];
        for (int i = m-1; i >= 0; i--) {
            for (int j = n-1; j >= 0; j--) {
                if (i == m-1 && j == n-1) dp[i][j] = Math.max(1 - dungeon[i][j], 1);
                else if (i < m-1 && j == n-1 ) dp[i][j] = Math.max(dp[i+1][j] - dungeon[i][j], 1);
                else if (i == m-1 && j < n-1) dp[i][j] = Math.max(dp[i][j+1] - dungeon[i][j], 1);
                else {
                    dp[i][j] =Math.max(Math.min(dp[i+1][j], dp[i][j+1]) - dungeon[i][j], 1);
                }
            }
        }
        return dp[0][0];

    }
    public static void main(String[] args) {
        p174 sol = new p174();
        sol.calculateMinimumHP(new int[][]{
                {1, -2, 3},
                {2, -2, -2}
        });
    }
}
