/**
 * Created by Valued Customer on 8/7/2017.
 * 25. Reverse Nodes in k-Group
 */
public class p025 {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode nextHead = head;
        int c = 0;
        while (c < k) {
            if (nextHead == null) return head;
            nextHead = nextHead.next;
            c++;
        }

        ListNode thisNewHead = reverseHelper(head, nextHead);
        head.next = reverseKGroup(nextHead, k);
        return thisNewHead;
    }

    private ListNode reverseHelper(ListNode begin, ListNode end) {
        if (begin.next == end) {
            begin.next = null;
            return begin;
        }
        ListNode head = reverseHelper(begin.next, end);
        ListNode next = begin.next;
        next.next = begin;
        begin.next = null;
        return head;
    }
}
