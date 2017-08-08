/**
 * Created by Valued Customer on 8/4/2017.
 * 21. Merge Two Sorted Lists
 */
public class p021 {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode itr = dummy;
        ListNode itr1 = l1, itr2 = l2;
        if (itr1 == null || itr2 == null) return itr1 == null?itr2:itr1;
        while (itr1 != null && itr2 != null) {
            ListNode min = itr1.val<itr2.val?itr1:itr2;
            itr.next = min;
            if (itr1 == min) itr1 = itr1.next;
            if (itr2 == min) itr2 = itr2.next;
            min.next = null;
            itr = itr.next;
        }
        if (itr1 != null) {
            itr.next = itr1;
        } else if (itr2 != null) {
            itr.next = itr2;
        }
        return dummy.next;
    }
}
