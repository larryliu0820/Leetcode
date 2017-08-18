import java.util.HashMap;
import java.util.Map;

/**
 * Created by Valued Customer on 7/29/2017.
 * 567. Permutation in String
 */
public class p567 {
    public boolean checkInclusion(String s1, String s2) {
        if (s2 == null || s2.length() == 0) return false;
        if (s1 == null || s1.length() == 0) return true;
        int memo[] = new int[26];

        for (int i = 0; i < s1.length(); i++) {
            memo[s1.charAt(i)-'a']++;
        }

        for (int i = 0; i < s2.length(); i++) {
            if (i >= s1.length()) memo[s2.charAt(i-s1.length())-'a']++;
            memo[s2.charAt(i)-'a']--;
            if (allZero(memo)) return true;
        }
        return false;

    }

    private boolean allZero(int[] a) {
        for (int i : a) if (i != 0) return false;
        return true;
    }
}
