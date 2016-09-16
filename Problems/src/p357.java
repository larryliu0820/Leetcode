/**
 * Created by Valued Customer on 9/15/2016.
 * 357. Count Numbers with Unique Digits
 * Given a non-negative integer n, count all numbers with unique digits, x, where 0 ≤ x < 10^n.

 Example:
 Given n = 2, return 91. (The answer should be the total numbers in the range of 0 ≤ x < 100, excluding [11,22,33,44,55,66,77,88,99])

 Show Hint

 */
public class p357 {
    public int countNumbersWithUniqueDigits(int n) {
        if (n > 9) return countNumbersWithUniqueDigits(9);
        int[] memo = new int[n+1];
        memo[0] = 1;
        for (int i = 1; i <= n; i++) {
            memo[i] = memo[i-1] + 9 * factorial(9, i-1);
        }
        return memo[n];

    }

    private int factorial(int n, int m) {
        int result = 1;
        int curr = n;
        for (int i = 0; i < m; i++) {
            result *= curr--;
        }
        return result;
    }

    public static void main(String[] args) {
        p357 sol = new p357();
        System.out.println(sol.countNumbersWithUniqueDigits(3));
    }
}
