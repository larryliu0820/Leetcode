/**
 * Created by Larry Liu on 9/26/2017.
 * 19. Remove Nth Node From End of List
 */
public class p019 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dhead = new ListNode(0), dtail = new ListNode(0);
        dhead.next = head;
        ListNode fast = dhead, slow = dhead;
        int i = 0;
        while (i < n) {
            if (fast == null) return null;
            fast = fast.next;
            i++;
        }
        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
        return dhead.next;
    }
}
