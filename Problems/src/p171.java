/**
 * Created by Valued Customer on 7/24/2017.
 * 171. Excel Sheet Column Number
 */
public class p171 {
    public int titleToNumber(String s) {
        int result = 0;
        int idx = 0;
        for (int i = s.length()-1; i >= 0; i--) {
            char c = s.charAt(i);
            result += (c - 'A' + 1) * Math.pow(26, idx++);
        }
        return result;
    }
}
