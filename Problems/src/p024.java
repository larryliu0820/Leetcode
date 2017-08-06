/**
 * Created by Valued Customer on 8/5/2017.
 * 24. Swap Nodes in Pairs
 */

public class p024 {
    public ListNode swapPairs(ListNode head) {
        if (head == null) return null;
        if (head.next == null) return head;

        ListNode nextHead = swapPairs(head.next.next);

        ListNode nextNode = head.next;
        nextNode.next = head;
        head.next = nextHead;
        return nextNode;
    }
}
