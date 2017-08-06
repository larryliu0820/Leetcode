/**
 * Created by Valued Customer on 7/24/2017.
 * 171. Excel Sheet Column Number
 */
public class p171 {
    public int titleToNumber(String s) {
        int result = 0;
        for (char c: s.toCharArray()) {
            result *= 26;
            result += c - 'A' + 1;
        }
        return result;
    }
}
