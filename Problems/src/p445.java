/**
 * Created by Valued Customer on 7/25/2017.
 * 445. Add Two Numbers II
 */
public class p445 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode leadingZero = new ListNode(0);
        ListNode itrZero = leadingZero;
        ListNode itr1 = l1, itr2 = l2;
        while (itr1.next != null && itr2.next != null) {
            itr1 = itr1.next;
            itr2 = itr2.next;
        }
        ListNode itr3 = itr2.next != null ? itr2:itr1;
        ListNode shortHead = itr2.next != null ? l1:l2;
        ListNode longHead = itr2.next != null ? l2:l1;
        while (itr3.next != null) {
            itr3 = itr3.next;
            itrZero.next = new ListNode(0);
            itrZero = itrZero.next;
        }
        itrZero.next = shortHead;
        ListNode result = new ListNode(0);
        int c = addHelper(longHead, leadingZero.next, result);
        if (c > 0) {
            ListNode newHead = new ListNode(c);
            newHead.next = result;
            return newHead;
        }
        return result;
    }

    private int addHelper(ListNode l1, ListNode l2, ListNode result) {
        if (l1 == null || l2 == null) return 0;
        int carry = 0;
        if (l1.next != null && l2.next != null) {
            result.next = new ListNode(0);
            carry = addHelper(l1.next, l2.next, result.next);
        }
        int sum = l1.val + l2.val + carry;
        result.val = sum % 10;
        return sum / 10;
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
