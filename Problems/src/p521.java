/**
 * Created by Larry Liu on 11/6/2017.
 * 521. Longest Uncommon Subsequence I
 */
public class p521 {
    public int findLUSlength(String a, String b) {
        return a.equals(b) ? -1 : Math.max(a.length(), b.length());
    }
}
