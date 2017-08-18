/**
 * Created by Valued Customer on 8/1/2017.
 * 650. 2 Keys Keyboard
 */
public class p650 {
    public int minSteps(int n) {
        if (n == 1) return 0;
        int[] dp = new int[n+1];
        dp[1] = 0;
        dp[2] = 2;

        for (int i = 3; i <= n; i++) {
            dp[i] = Integer.MAX_VALUE;
            for (int j = 1; j <= i/2; j++) {
                if (i % j != 0) continue;
                dp[i] = Math.min(i/j + dp[j], dp[i]);
            }
        }
        return dp[n];

    }
}
