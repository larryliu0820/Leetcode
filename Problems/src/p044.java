/**
 * Created by mengwliu on 8/31/17
 * 44. Wildcard Matching
 */
public class p044 {
    public boolean isMatch(String s, String p) {
        int m = s.length(), n = p.length();
        boolean[][] dp = new boolean[m+1][n+1];
        dp[0][0] = true;
        for (int j = 1; j <= n; j++) {
            if (p.charAt(j-1) == '*')
                dp[0][j] = true;
            else
                break;
        }
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                char cp = p.charAt(j-1);
                if (cp == s.charAt(i-1) || cp == '?') {
                    dp[i][j] = dp[i-1][j-1];
                } else if (cp == '*') {
                    dp[i][j] = dp[i-1][j] || dp[i][j-1];
                } else dp[i][j] = false;
            }
        }
        return dp[m][n];
    }

    public static void main(String[] args) {
        p044 sol = new p044();
        sol.isMatch("aab", "c*a*b");
    }
}
