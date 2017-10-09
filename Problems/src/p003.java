import java.util.HashMap;

/**
 * Created by mengwliu on 7/26/16.
 * 3. Longest Substring Without Repeating Characters
 * Given a string, find the length of the longest substring without repeating characters.

 Examples:

 Given "abcabcbb", the answer is "abc", which the length is 3.

 Given "bbbbb", the answer is "b", with the length of 1.

 Given "pwwkew", the answer is "wke", with the length of 3. Note that the answer must be a substring, "pwke" is a subsequence and not a substring.
 */
public class p003 {
    public int lengthOfLongestSubstring(String s) {
        if (s.length() == 0) return 0;
        int[] map = new int[128];
        for (int i = 0; i < map.length; i++) map[i] = -1;
        int max = 0;
        for (int i = 0, j = 0; i < s.length(); i++) {
            if (map[s.charAt(i)] >= 0) {
                j = Math.max(j, map[s.charAt(i)]+1);
            }
            map[s.charAt(i)] = i;
            max = Math.max(max, i-j+1);
        }
        return max;
    }

    public static void main(String[] args) {
        p003 sol = new p003();
        System.out.println(sol.lengthOfLongestSubstring("bbbbbb"));
    }
}

