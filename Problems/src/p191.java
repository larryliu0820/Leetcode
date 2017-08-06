/**
 * Created by Valued Customer on 7/28/2017.
 * 191. Number of 1 Bits
 */
public class p191 {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int count = 0;
        while (n != 0)  {
            n &= n-1;
            count++;
        }
        return count;
    }
}