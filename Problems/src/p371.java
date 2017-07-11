/**
 * Created by Valued Customer on 7/6/2017.
 *
 * 371. Sum of Two Integers
 *
 * Calculate the sum of two integers a and b, but you are not allowed to use the operator + and -.

 Example:
 Given a = 1 and b = 2, return 3.
 */
public class p371 {
    public int getSum(int a, int b) {
        int carry = 0;
        int sum = 0;
        int currSum = 0;

        for (int digit = 0; digit < 32; digit++) {
            int abit = a & 1;
            int bbit = b & 1;
            a >>= 1;
            b >>= 1;
            currSum = (abit ^ bbit) ^ carry;
            currSum <<= digit;
            sum |= currSum;
            carry = (abit & bbit) | (carry & (abit ^ bbit));
        }
        return sum;
    }
}
