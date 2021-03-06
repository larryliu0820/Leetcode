/**
 * Created by Valued Customer on 8/31/2017.
 * 50. Pow(x, n)
 * Implement pow(x, n).
 */
public class p050 {
    public double myPow(double x, int n) {
        if (n == 0) return 1;
        double t = myPow(x, n/2);
        if (n % 2 != 0) return n < 0? (1/x) * t * t : x * t * t;
        else return t*t;
    }

    public static void main(String[] args) {
        p050 sol = new p050();
        System.out.println("result = " + sol.myPow(34.00515, -3));
    }
}
