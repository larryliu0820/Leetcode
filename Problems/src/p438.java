import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Valued Customer on 7/10/2017.
 *
 * 438. Find All Anagrams in a String
 */
public class p438 {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();
        if (s == null || s.length() < p.length()) return result;
        Map<Character, Integer> refMap = new HashMap<>();
        for (char c : p.toCharArray()) {
            refMap.putIfAbsent(c, 0);
            refMap.put(c, refMap.get(c)+1);
        }
        Map<Character, Integer> map = new HashMap<>(refMap);
        for (int i = 0; i < p.length(); i++) {
            char c = s.charAt(i);
            if (refMap.containsKey(c)) {
                map.putIfAbsent(c, 0);
                map.put(c, map.get(c)-1);
                if (map.get(c) == 0) map.remove(c);
            }
        }

        if (map.isEmpty()) result.add(0);
        for (int i = p.length(); i < s.length(); i++) {
            char tail = s.charAt(i-p.length());
            char head = s.charAt(i);
            if (refMap.containsKey(tail)) {
                map.putIfAbsent(tail, 0);
                map.put(tail, map.get(tail)+1);
                if (map.get(tail) == 0) map.remove(tail);
            }
            if (refMap.containsKey(head)) {
                map.putIfAbsent(head, 0);
                map.put(head, map.get(head)-1);
                if (map.get(head) == 0) map.remove(head);
            }
            if (map.isEmpty()) result.add(i-p.length()+1);
        }

        return result;
    }

    public static void main(String[] args) {
        String p = "abc";
        String s = "abacbabc";
        p438 sol = new p438();
        sol.findAnagrams(s, p);
    }
}
