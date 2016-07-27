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
        HashMap<Character, Integer> visitedMap = new HashMap<>();
        int maxLen = 1;
        int startInd = 0;
        visitedMap.put(s.charAt(0),0);
        for (int i = 1; i < s.length(); i++) {
            System.out.println("i = "+i);
            char c = s.charAt(i);
            if (visitedMap.containsKey(c)) {
                startInd = visitedMap.get(c) + 1;
                visitedMap.remove(c);
            }
            System.out.println("startInd = "+startInd);
            System.out.println("maxlen = " + maxLen);
            if (maxLen < i - startInd + 1) maxLen = i - startInd + 1;
            visitedMap.put(c, i);
        }
        return maxLen;
    }

    public static void main(String[] args) {
        p003 sol = new p003();
        sol.lengthOfLongestSubstring("abba");
    }
}

