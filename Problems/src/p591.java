import java.util.Stack;

/**
 * Created by Valued Customer on 7/30/2017.
 * 591. Tag Validator
 */
public class p591 {
    public boolean isValid(String code) {
        Stack<String> stack = new Stack<>();
        int i = 0;
        while (i < code.length()) {
            if(i>0 && stack.isEmpty()) return false;
            if (code.startsWith("<![CDATA[", i)) {
                int j = i + 9;
                i = code.indexOf("]]>", j);
                if (i < 0) return false;
                i += 3;
            } else if (code.startsWith("</", i)) {
                int j = i + 2;
                i = code.indexOf(">", j);
                if (i < 0 || i == j || i - j > 9) return false;
                for (int k = j; k < i; k++) if (code.charAt(k) > 'Z' || code.charAt(k) < 'A') return false;
                String s = code.substring(j, i++);
                if (stack.isEmpty() || !stack.pop().equals(s)) return false;
            } else if (code.startsWith("<", i)) {
                int j = i + 1;
                i = code.indexOf(">", j);
                if (i < 0 || i == j || i - j > 9) return false;
                for (int k = j; k < i; k++) if (code.charAt(k) > 'Z' || code.charAt(k) < 'A') return false;
                String s = code.substring(j, i++);
                stack.push(s);
            } else i++;
        }
        return stack.isEmpty();
    }
}
