/**
 * Created by Valued Customer on 9/12/2016.
 * 326. Power of Three
 * Given an integer, write a function to determine if it is a power of three.
 * Follow up:
 Could you do it without using any loop / recursion?
 */
public class p326 {
    public boolean isPowerOfThree(int n) {
        return ( n>0 &&  1162261467%n==0);
    }
}
