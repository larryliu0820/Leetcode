/**
 * Created by Valued Customer on 8/20/2016.
 * 231. Power of Two
 * Given an integer, write a function to determine if it is a power of two.
 */
public class p231 {
    public boolean isPowerOfTwo(int n) {
        if (n <= 0) return false;
        return (n ^ (n-1)) == 0;
    }
}
