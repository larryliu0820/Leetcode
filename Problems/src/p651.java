/**
 * Created by Valued Customer on 8/10/2017.
 * 651. 4 Keys Keyboard
 */
public class p651 {
    public int maxA(int N) {
        if (N <= 3) return N;
        int[] dp = new int[N+1];
        for (int i = 4; i <= N; i++) {
            int maxValue = i;
            for (int j = 2; j < i-2; j++) {
                maxValue = Math.max(maxValue, dp[j] * (i - j - 2));
            }
            dp[i] = maxValue;
        }
        return dp[N];
    }
}
