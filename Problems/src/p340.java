import java.util.HashMap;
import java.util.Map;

/**
 * Created by Valued Customer on 9/20/2016.
 * 340. Longest Substring with At Most K Distinct Characters
 * Given a string, find the length of the longest substring T that contains at most k distinct characters.

 For example, Given s = “eceba” and k = 2,

 T is "ece" which its length is 3.

 Show Company Tags
 Show Tags
 Show Similar Problems

 */
public class p340 {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        if (s == null || s.length() == 0 || k == 0) return 0;
        if (k >= s.length()) return s.length();
        StringBuilder sb = new StringBuilder();
        Map<Character, Integer> map = new HashMap<>();
        int max = 0;
        for (int i = 0; i < s.length(); i++) {
            char curr = s.charAt(i);
            if (map.containsKey(curr)) {
                map.put(curr, map.get(curr)+1);
                sb.append(curr);
            } else {

                while(map.keySet().size() >= k) {
                    if (map.get(sb.charAt(0)) != 1) map.put(sb.charAt(0), map.get(sb.charAt(0))-1);
                    else map.remove(sb.charAt(0));
                    sb.deleteCharAt(0);
                }

                map.put(curr, 1);
                sb.append(curr);
            }
            max = Math.max(max, sb.length());
        }
        return max;
    }
}
