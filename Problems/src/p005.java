/**
 * Created by mengwliu on 7/27/16.
 * 5. Longest Palindromic Substring
 * Given a string S, find the longest palindromic substring in S.
 * You may assume that the maximum length of S is 1000, and there exists one unique longest palindromic substring.
 */
public class p005 {
    public String longestPalindrome(String s) {
        int maxLen = 1;
        String p = "";
        for (int i = 0; i < s.length() - 1; i++) {
            int len = expandToFind(s, i, i);
            int len2 = expandToFind(s, i, i+1);

        }
        return p;
    }

    public int expandToFind(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return right - left - 1;
    }
}
