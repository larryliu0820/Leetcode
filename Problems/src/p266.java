import java.util.HashSet;
import java.util.Set;

/**
 * Created by Valued Customer on 9/14/2016.
 * 266. Palindrome Permutation
 * Given a string, determine if a permutation of the string could form a palindrome.

 For example,
 "code" -> False, "aab" -> True, "carerac" -> True.
 */
public class p266 {
    public boolean canPermutePalindrome(String s) {
        if (s == null || s.length() == 0) return false;
        Set<Character> memo = new HashSet<>();
        for (char c: s.toCharArray()) {
            if (memo.contains(c))  memo.remove(c);
            else memo.add(c);
        }
        if (s.length() % 2 == 0) return memo.size() == 0;
        return memo.size() == 1;
    }
}
