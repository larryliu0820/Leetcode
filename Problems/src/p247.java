import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Valued Customer on 8/26/2016.
 * 247. Strobogrammatic Number II
 * A strobogrammatic number is a number that looks the same when rotated 180 degrees (looked at upside down).

 Find all strobogrammatic numbers that are of length = n.

 For example,
 Given n = 2, return ["11","69","88","96"].
 */
public class p247 {
    public List<String> findStrobogrammatic(int n) {

        Map<Character, Character> map = new HashMap<>();
        map.put('8','8');
        map.put('6','9');
        map.put('9','6');
        map.put('1','1');
        map.put('0','0');

        List<String> result = new ArrayList<>();
        helper(result, map, "", n);
        return result;

    }

    public void helper(List<String> result, Map<Character,Character> map, String curr, int n) {
        if (n-curr.length() == 0) {
            if (curr != "0" && !curr.startsWith("0"))
                result.add(curr);
            return;
        }
        if (n-curr.length() == 1) {
            char[] list = new char[]{'0','1','8'};
            String str = curr.substring(0, curr.length()/2);
            for (char key : list) {
                helper(result, map, str + key + curr.substring(curr.length()/2), n);
            }
            return;
        }
        for (char key : map.keySet()) {
            helper(result, map, key + curr + map.get(key), n);
        }
    }

    public static void main(String[] args) {
        p247 sol = new p247();
        System.out.println(sol.findStrobogrammatic(3).toString());
    }
}
