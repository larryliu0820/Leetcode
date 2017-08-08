import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * Created by Valued Customer on 8/4/2017.
 * 20. Valid Parentheses
 */
public class p020 {
    public boolean isValid(String s) {
        Map<Character, Character> map = new HashMap<>();
        map.put(')', '(');
        map.put(']', '[');
        map.put('}', '{');
        String left = "([{";
        Stack<Character> stack = new Stack<>();
        for (char c: s.toCharArray()) {
            if (left.indexOf(c) != -1) {
                stack.push(c);
            } else if (map.containsKey(c)) {
                if (stack.isEmpty() || stack.peek() != map.get(c)) return false;
                stack.pop();
            }
        }
        return stack.isEmpty();
    }
}
