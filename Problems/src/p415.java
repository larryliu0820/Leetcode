/**
 * Created by Larry Liu on 11/4/2017.
 * 415. Add Strings
 */
public class p415 {
    public String addStrings(String num1, String num2) {
        StringBuilder shorter = new StringBuilder(num1.length() > num2.length()?num2:num1);
        String longer = num1.length() > num2.length() ? num1: num2;
        for (int i = shorter.length(); i < longer.length(); i++) shorter.insert(0, '0');
        int carry = 0;
        StringBuilder sb = new StringBuilder();
        for (int i = shorter.length() - 1; i >= 0; i--) {
            sb.insert(0, (longer.charAt(i) - '0' + shorter.charAt(i) - '0' + carry) % 10);
            carry = addDigits(longer.charAt(i), shorter.charAt(i), carry);
        }

        if (carry > 0) sb.insert(0, carry);
        return sb.toString();
    }

    private int addDigits(char c1, char c2, int carry) {
        int n1 = c1 - '0';
        int n2 = c2 - '0';
        return (n1 + n2 + carry) / 10;
    }

    public static void main(String[] args) {
        p415 sol = new p415();
        sol.addStrings("9", "99");
    }
}
