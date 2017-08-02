import java.util.List;

/**
 * Created by Valued Customer on 7/25/2017.
 * 445. Add Two Numbers II
 */
public class p445 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        ListNode itr1 = l1, itr2 = l2;
        while (itr1.next != null && itr2.next != null) {
            itr1 = itr1.next;
            itr2 = itr2.next;
        }
        ListNode lhead = itr1.next == null?l2:l1;
        ListNode shead = itr1.next == null?l1:l2;
        ListNode ltail = itr1.next == null?itr2:itr1;

        ListNode zeroHead = new ListNode(0);
        ListNode zeroItr = zeroHead;
        while (ltail.next != null) {
            zeroItr.next = new ListNode(0);
            zeroItr = zeroItr.next;
            ltail = ltail.next;
        }

        zeroItr.next = shead;

        ListNode result = new ListNode(0);
        int carry = addHelper(lhead, zeroHead.next, result);
        if (carry > 0) {
            ListNode res = new ListNode(carry);
            res.next = result;
            return res;
        }
        return result;
    }

    private int addHelper(ListNode l1, ListNode l2, ListNode result) {
        int carry = 0;
        if (l1.next != null && l2.next != null) {
            result.next = new ListNode(0);
            carry = addHelper(l1.next, l2.next, result.next);
        }
        result.val = (l1.val + l2.val + carry) % 10;
        return (l1.val + l2.val + carry) / 10;
    }
    public static void main(String[] args) {
        ListNode l1 = new ListNode(7);
        ListNode itr = l1;
        for (int i : new int[]{2, 4, 3}) {
            itr.next = new ListNode(i);
            itr = itr.next;
        }
        ListNode l2 = new ListNode(5);
        itr = l2;
        for (int i : new int[]{6,4}) {
            itr.next = new ListNode(i);
            itr = itr.next;
        }
        p445 sol = new p445();
        ListNode result = sol.addTwoNumbers(l1, l2);
    }
}
