/**
 * Created by Valued Customer on 7/29/2017.
 * 365. Water and Jug Problem
 */
public class p365 {
    public boolean canMeasureWater(int x, int y, int z) {
        return z == 0 || (long)x + y >= z && z % gcd(x, y) == 0;
    }
    private int gcd(int x, int y) {
        return y == 0 ? x : gcd(y, x % y);
    }
}
