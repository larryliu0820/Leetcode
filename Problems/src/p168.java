/**
 * Created by Valued Customer on 7/27/2017.
 * 168. Excel Sheet Column Title
 */
public class p168 {
    public String convertToTitle(int n) {
        String result = "";
        while (n > 0) {
            int v = (n-1) % 26;
            result = (char)('A' + v) + result;
            n = (n-1) / 26;
        }
        return result;
    }
}
