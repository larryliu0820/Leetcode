import java.util.HashMap;
import java.util.Map;

/**
 * Created by Valued Customer on 8/21/2016.
 * 246. Strobogrammatic Number
 * A strobogrammatic number is a number that looks the same when rotated 180 degrees (looked at upside down).

 Write a function to determine if a number is strobogrammatic. The number is represented as a string.

 For example, the numbers "69", "88", and "818" are all strobogrammatic.
 */
public class p246 {
    public boolean isStrobogrammatic(String num) {
        Map<Character, Character> map = new HashMap<>();
        map.put('8','8');
        map.put('6','9');
        map.put('9','6');
        map.put('1','1');
        map.put('0','0');
        if (num == null || num.length() == 0) return false;
        int left, right = num.length() / 2;
        if (num.length() % 2 == 0) {
            left = num.length() / 2 - 1;
        } else {
            left = num.length() / 2;
        }

        while (left >= 0 && right < num.length()) {
            if (!map.containsKey(num.charAt(left)) || map.get(num.charAt(left)) != num.charAt(right))
                return false;
            left--;
            right++;
        }
        return true;
    }
}
