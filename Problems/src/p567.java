import java.util.HashMap;
import java.util.Map;

/**
 * Created by Valued Customer on 7/29/2017.
 * 567. Permutation in String
 */
public class p567 {
    public boolean checkInclusion(String s1, String s2) {
        Map<Character, Integer> dict = new HashMap<>();
        for (char c : s1.toCharArray()) {
            dict.putIfAbsent(c, 0);
            dict.put(c, dict.get(c)+1);
        }
        int begin = 0, end = s1.length()-1;
        while (end < s2.length()) {
            if (dict.containsKey(s2.charAt(begin))) {
                if (helper(s2, begin, end, dict)) return true;
            }
            begin++;
            end++;
        }
        return false;
    }

    private boolean helper(String s1, int begin, int end, Map<Character, Integer> map) {
        Map<Character, Integer> mapCopy = new HashMap<>(map);
        for (int i = begin; i <= end; i++) {
            char c = s1.charAt(i);
            if (!mapCopy.containsKey(c)) return false;
            else if (mapCopy.get(c) == 1) mapCopy.remove(c);
            else {
                mapCopy.put(c, mapCopy.get(c)-1);
            }
        }
        return mapCopy.isEmpty();
    }
}
