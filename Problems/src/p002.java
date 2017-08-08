import java.util.List;

/**
 * Created by Valued Customer on 8/4/2017.
 * 2. Add Two Numbers
 */
public class p002 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry = 0;
        ListNode itr1 = l1, itr2 = l2;
        ListNode result = new ListNode(0);
        ListNode itr3 = result;
        while (itr1 != null || itr2 != null || carry > 0) {
            int val1 = itr1 != null ? itr1.val:0;
            int val2 = itr2 != null ? itr2.val:0;
            itr3.next = new ListNode((val1 + val2 + carry) % 10);
            carry = (val1 + val2 + carry) / 10;
            itr3 = itr3.next;
            if (itr1 != null) itr1 = itr1.next;
            if (itr2 != null) itr2 = itr2.next;
        }
        return result.next;
    }
}
