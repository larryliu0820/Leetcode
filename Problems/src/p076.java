import sun.plugin.net.protocol.jar.CachedJarURLConnection;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

/**
 * Created by mengwliu on 9/5/17
 * 76. Minimum Window Substring
 */
public class p076 {
    public String minWindow(String s, String t) {
        int[] dict = new int[128];
        for (char c : t.toCharArray()) dict[c]++;
        int minWidth = Integer.MAX_VALUE;
        String res = "";
        int count = t.length(), begin = 0;
        for (int i = 0; i < s.length(); i++) {
            char currChar = s.charAt(i);
            if (dict[currChar]-->0) {
                count--;
            }
            while (count == 0) {
                if (i - begin < minWidth) {
                    minWidth = i - begin;
                    res = s.substring(begin, i+1);
                }
                if (dict[s.charAt(begin++)]++ == 0) count++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        p076 sol = new p076();
        sol.minWindow("bba", "ab");
    }
}
