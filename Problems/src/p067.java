/**
 * Created by larryliu on 9/18/16.
 * 67. Add Binary
 * Given two binary strings, return their sum (also a binary string).

 For example,
 a = "11"
 b = "1"
 Return "100".
 */
public class p067 {
    public String addBinary(String a, String b) {
        String longStr = a.length() > b.length()?a:b;
        String shortStr = a.length() > b.length()?b:a;
        for (int i = shortStr.length(); i < longStr.length(); i++) shortStr = '0' + shortStr;
        int itr = longStr.length() - 1;
        String result = "";
        int carry = 0;
        while (itr >= 0) {
            int sum = longStr.charAt(itr) - '0' + shortStr.charAt(itr) - '0' + carry;
            result = (char)('0' + sum % 2 ) + result;
            carry = sum / 2;
            itr--;
        }
        if (carry == 1) result = '1' + result;
        return result;
    }
}
