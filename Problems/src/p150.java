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
        return 0;
    }

    public int evalRPNHelper(String[] tokens, int begin, int end) {
        String operators = "+-*/";
        String operator = tokens[end];
        if (operators.contains(tokens[end - 1]))
            return 0;
        return 0;
    }

    public String[] computeOnce(String[] tokens, int begin, int end) {
        int op1 = Integer.parseInt(tokens[begin]);
        int op2 = Integer.parseInt(tokens[begin+1]);
        int result = 0;
        switch (tokens[end]) {
            case "+":
                result = op1 + op2;
                break;
            case "-":
                result = op1 - op2;
                break;
            case "*":
                result = op1 * op2;
                break;
            default:
                result = op1 / op2;
        }
        System.out.println("op1 = " + op1 + ", op2 = " + op2 + ", result = " + result);
        String[] newTokens = new String[tokens.length - 2];
        for (int i = 0; i < begin; i ++) newTokens[i] = tokens[i];
        newTokens[begin] = Integer.toString(result);
        for (int i = end+1; i < tokens.length; i++) newTokens[i-2] = tokens[i];
        return newTokens;
    }

    public static void main(String[] args) {
        p150 sol = new p150();
        String[] tokens = new String[]{"4","13","5","/","+"};
        System.out.println(sol.evalRPN(tokens));
    }
}
