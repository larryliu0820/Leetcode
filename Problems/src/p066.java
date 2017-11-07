import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Larry Liu on 11/6/2017.
 */
public class p066 {
    public int[] plusOne(int[] digits) {
        List<Integer> list = new LinkedList<>();
        int carry = 1;
        for (int i = digits.length-1; i >= 0; i--) {
            if (carry > 0) {
                int sum = digits[i] + carry;
                carry = sum / 10;
                list.add(0, sum % 10);
            } else list.add(0, digits[i]);
        }
        if (carry > 0) list.add(0, carry);
        int[] arr = new int[list.size()];
        for (int i = 0; i < list.size(); i++) arr[i] = list.get(i);
        return arr;
    }
}
