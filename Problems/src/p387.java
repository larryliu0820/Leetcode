import java.util.Stack;

/**
 * Created by Valued Customer on 7/28/2017.
 * 387. First Unique Character in a String
 */
public class p387 {
    public int firstUniqChar(String s) {
        int[] memo = new int[26];
        for (char c : s.toCharArray()) memo[c-'a']++;
        for (int i = 0; i < s.length(); i++) {
            if (memo[s.charAt(i)-'a'] == 1) return i;
        }
        return -1;
    }

    public static void main(String[] args) {
        p387 sol = new p387();
        sol.firstUniqChar("loveleetcode");
    }
}
