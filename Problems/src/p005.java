/**
 * Created by mengwliu on 7/27/16.
 * 5. Longest Palindromic Substring
 * Given a string S, find the longest palindromic substring in S.
 * You may assume that the maximum length of S is 1000, and there exists one unique longest palindromic substring.
 */
public class p005 {

    public String longestPalindrome(String s) {
        int maxLen = 0;
        String result = s.substring(0,1);
        for (int i = 0; i < s.length() - maxLen/2; i++) {
            String s1 = expandToFind(s, i, i);
            if (s1.length() > maxLen) {
                maxLen = s1.length();
                result = s1;
            }
            String s2 = expandToFind(s, i, i+1);
            if (s2.length() > maxLen) {
                maxLen = s2.length();
                result = s2;
            }

        }
        return result;
    }

    private String expandToFind(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return s.substring((left+1)<0?0:(left+1), right);
    }
    public static void main(String[] args) {
        p005 sol = new p005();
        String result = sol.longestPalindrome("a");
        System.out.println("result = " + result);
    }
}
