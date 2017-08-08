/**
 * Created by Valued Customer on 7/27/2017.
 * 168. Excel Sheet Column Title
 */
public class p168 {
    public String convertToTitle(int n) {
        String res = "";
        while (n > 0) {
            res = (char)('A' + (n-1) % 26) + res;
            n = (n-1)/26;
        }
        return res;
    }
}
