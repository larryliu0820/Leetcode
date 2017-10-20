import java.util.Stack;

/**
 * Created by Larry Liu on 10/18/2017.
 * 536. Construct Binary Tree from String
 * 4(2(3)(1))(6(5))
 */
public class p536 {
    public TreeNode str2tree(String s) {
        Stack<TreeNode> stack = new Stack<>();
        s += '(';
        StringBuilder value = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(' || c == ')') {
                if (value.length() > 0) {
                    int val = Integer.parseInt(value.toString());
                    value = new StringBuilder();
                    TreeNode curr = new TreeNode(val);
                    if (!stack.isEmpty()) {
                        if (stack.peek().left == null) stack.peek().left = curr;
                        else stack.peek().right = curr;
                    }
                    stack.push(curr);
                }
                if (c == ')') stack.pop();
            } else if (c == '-' || Character.isDigit(c)) {
                value.append(c);
            }
        }
        return stack.isEmpty()? null: stack.firstElement();
    }
}
