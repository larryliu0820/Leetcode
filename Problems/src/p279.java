import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Valued Customer on 8/14/2016.
 * 279. Perfect Squares
 * Given a positive integer n, find the least number of perfect square numbers (for example, 1, 4, 9, 16, ...) which sum to n.

 For example, given n = 12, return 3 because 12 = 4 + 4 + 4; given n = 13, return 2 because 13 = 4 + 9.
 */
public class p279 {
    public int numSquares(int n) {
        int square_root=1;
        int[] dp = new int[n+1];
        for(int i = 1;i<n+1;i++){
            if(i == square_root*square_root){
                dp[i] = 1;
                square_root++;
            }else{
                int min = i;
                for(int j = square_root-1;j>0;j--)
                    min = Math.min(min,1+dp[i-j*j]);
                dp[i] = min;
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        p279 sol = new p279();
        System.out.println(sol.numSquares(1));
    }
}
