/**
 * Created by larryliu on 9/3/17.
 * 67. Add Binary
 * Given two binary strings, return their sum (also a binary string).

 For example,
 a = "11"
 b = "1"
 Return "100".
 */
public class p067 {
    public String addBinary(String a, String b) {
        StringBuilder sb = new StringBuilder();
        int itrA = a.length()-1;
        int itrB = b.length()-1;
        int carry = 0;
        while (itrA >= 0 || itrB >= 0) {
            int valA = itrA<0?0:(a.charAt(itrA--)-'0');
            int valB = itrB<0?0:(b.charAt(itrB--)-'0');
            int sum = valA + valB + carry;
            carry = sum / 2;
            sum %= 2;
            sb.insert(0, sum);
        }
        if (carry > 0) {
            sb.insert(0, carry);
        }
        return sb.toString();
    }
}
