/**
 * Created by Valued Customer on 9/3/2017.
 * 69. Sqrt(x)
 * Implement int sqrt(int x).

 Compute and return the square root of x.
 * */
public class p069 {
    public int mySqrt(int x) {
        if (x == 0) return 0;
        int s = 1, e = x;

        while (s <= e) {
            int m = s / 2 + e / 2 + (s % 2 + e % 2) / 2;
            int q = x / m;
            if (q == m) return m;
            else if (q < m) e = m - 1;
            else s = m + 1;
        }

        return e;
    }

    public static void main(String[] args) {
        p069 sol = new p069();
        System.out.println(sol.mySqrt(3));
    }
}
