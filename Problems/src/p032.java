import java.util.Stack;

/**
 * Created by Valued Customer on 7/28/2016.
 * 32. Longest Valid Parentheses
 * Given a string containing just the characters '(' and ')', find the length of the longest valid (well-formed) parentheses substring.

 For "(()", the longest valid parentheses substring is "()", which has length = 2.

 Another example is ")()())", where the longest valid parentheses substring is "()()", which has length = 4.
 */
public class p032 {
    public int longestValidParentheses(String s) {
        if (s.length() == 0) return 0;
        Stack<Integer> stack = new Stack<>();
        boolean[] seq = new boolean[s.length()];
        int start = 0, end = s.length() - 1;
        char[] sc = s.toCharArray();
        while (start < sc.length && sc[start] == ')') start++;
        while (end >= 0 && sc[end] == '(') end--;

        for (int i = start; i <= end; i++) {
            if (sc[i] == '(') stack.push(i);
            else if (sc[i] == ')' && !stack.isEmpty()) {
                int lastLeft = stack.pop();
                seq[lastLeft] = true;
                seq[i] = true;
            }
        }
        int maxLen = 0, i = 0;
        while (i < seq.length) {
            if (seq[i]) {
                int len = 0;
                while (i < seq.length && seq[i]) {
                    i++;
                    len++;
                }
                maxLen = maxLen > len? maxLen:len;
            }
            i++;
        }
        return maxLen;
    }

    public static void main(String[] args) {
        p032 sol = new p032();
        System.out.println("result = " + sol.longestValidParentheses("()"));
    }
}
