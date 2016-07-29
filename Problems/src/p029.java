/**
 * Created by mengwliu on 7/28/16.
 * 29. Divide Two Integers
 *  Divide two integers without using multiplication, division and mod operator.

 If it is overflow, return MAX_INT.
 */
public class p029 {
    public int divide(int dividend, int divisor) {
        if (divisor == 0) return Integer.MAX_VALUE;
        if (dividend == Integer.MIN_VALUE) {
            if (divisor == -1)
                return Integer.MAX_VALUE;
            else if (divisor == Integer.MIN_VALUE)
                return 1;
            else
                return divide(dividend + Math.abs(divisor), divisor) + (divisor > 0 ? -1: 1);
        }
        if (divisor == Integer.MIN_VALUE) return 0;
        boolean negative = dividend > 0 ^ divisor > 0;
        int result = 0;
        divisor = Math.abs(divisor);
        dividend = Math.abs(dividend);
        if (divisor == 1) {
            result = dividend;
        } else {
            while (dividend >= divisor) {
                System.out.println("dividend = " + dividend + ", divisor = " + divisor);
                int tempDivisor = divisor, tempResult = 1;
                while (dividend - tempDivisor >= tempDivisor) {
                    tempDivisor <<= 1;
                    tempResult <<= 1;
                }
                dividend -= tempDivisor;
                result += tempResult;
            }
        }
        return negative?-result:result;
    }

    public static void main(String[] args) {
        p029 sol = new p029();
        System.out.println("result = " + sol.divide(2,2));
    }
}
