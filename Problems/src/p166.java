import java.util.HashMap;
import java.util.Map;

/**
 * Created by mengwliu on 8/12/16.
 * 166. Fraction to Recurring Decimal
 * Given two integers representing the numerator and denominator of a fraction, return the fraction in string format.

 If the fractional part is repeating, enclose the repeating part in parentheses.

 For example,

 Given numerator = 1, denominator = 2, return "0.5".
 Given numerator = 2, denominator = 1, return "2".
 Given numerator = 2, denominator = 3, return "0.(6)".

 */
public class p166 {
    public String fractionToDecimal(int numerator, int denominator) {
        if (numerator == 0) return "0";
        if (numerator == Integer.MIN_VALUE && denominator == -1)
            return Integer.toString(numerator).substring(1);
        boolean isNeg = numerator < 0 ^ denominator < 0;
        long n = Math.abs((long)numerator);
        long d = Math.abs((long)denominator);
        String result = (numerator/denominator == 0 && isNeg) ? "-0":Integer.toString(numerator/denominator);
        long residual = n % d;
        if (residual == 0) return result;
        String repeat = "";
        Map<Long,Integer> residualIndex = new HashMap<>();
        int index = 0;
        residualIndex.put(residual, index);
        do {
            residual *= 10;
            repeat += residual / d;
            residual %= d;
            index++;
            if (residualIndex.containsKey(residual)) break;
            else residualIndex.put(residual, index);
        } while ( residual != 0);
        if (residual == 0) return result+"."+repeat;
        else {
            int ind = residualIndex.get(residual);
            repeat = repeat.substring(0, ind) + "(" + repeat.substring(ind) + ")";
            return result+"."+repeat;
        }
    }

    public static void main(String[] args) {
        p166 sol = new p166();
        System.out.println(sol.fractionToDecimal(1, Integer.MIN_VALUE));
    }
}
