/**
 * Created by mengwliu on 7/27/16.
 * 5. Longest Palindromic Substring
 * Given a string S, find the longest palindromic substring in S.
 * You may assume that the maximum length of S is 1000, and there exists one unique longest palindromic substring.
 */
public class p005 {
    public String longestPalindrome(String s) {
        if (s.length() == 1) return s;
        int maxLen = 0;
        String p = "";
        for (int i = 0; i < s.length() - 1; i++) {
            int len = expandToFind(s, i, i);
            int len2 = expandToFind(s, i, i+1);
            int larger = len > len2?len:len2;
            if (larger > maxLen) {
                maxLen = larger;
                p = s.substring(larger%2==0?i-maxLen/2+1:i-maxLen/2, i+maxLen/2+1);
            }

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

    public static void main(String[] args) {
        p005 sol = new p005();
        String result = sol.longestPalindrome("bb");
        System.out.println("result = " + result);
    }
}
