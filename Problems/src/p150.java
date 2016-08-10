import java.util.Stack;

/**
 * Created by mengwliu on 8/9/16.
 * 150. Evaluate Reverse Polish Notation
 *  Evaluate the value of an arithmetic expression in Reverse Polish Notation.

 Valid operators are +, -, *, /. Each operand may be an integer or another expression.

 Some examples:

 ["2", "1", "+", "3", "*"] -> ((2 + 1) * 3) -> 9
 ["4", "13", "5", "/", "+"] -> (4 + (13 / 5)) -> 6

 */
public class p150 {
    public int evalRPN(String[] tokens) {
        String operators = "+-*/";
        Stack<String> stack = new Stack<>();

        for (int i = tokens.length - 1; i >= 0; i --) {
            if (operators.contains(tokens[i])) {
                stack.push(tokens[i]);
            } else {
                String op1 = tokens[i];
                while (!stack.isEmpty() && !operators.contains(stack.peek())) {
                    String op2 = stack.pop();
                    String operator = stack.pop();
                    op1 = computeOnce(op1, op2, operator);
                }
                stack.push(op1);
            }
        }
        return Integer.parseInt(stack.pop());
    }


    public String computeOnce(String op1, String op2, String operator) {
        System.out.println("op1 = " + op1 + ", op2 = " + op2 + ", operator = " + operator);
        int opInt1 = Integer.parseInt(op1);
        int opInt2 = Integer.parseInt(op2);
        switch (operator) {
            case "+":
                return Integer.toString(opInt1 + opInt2);
            case "-":
                return Integer.toString(opInt1 - opInt2);
            case "*":
                return Integer.toString(opInt1 * opInt2);
            default:
                return Integer.toString(opInt1 / opInt2);
        }

//        String[] newTokens = new String[tokens.length - 2];
//        for (int i = 0; i < begin; i ++) newTokens[i] = tokens[i];
//        newTokens[begin] = Integer.toString(result);
//        for (int i = end+1; i < tokens.length; i++) newTokens[i-2] = tokens[i];
//        return newTokens;
    }

    public static void main(String[] args) {
        p150 sol = new p150();
        String[] tokens = new String[]{"4","13","5","/","+"};
        System.out.println(sol.evalRPN(tokens));
    }
}
