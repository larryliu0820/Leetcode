import java.util.Stack;

/**
 * Created by Valued Customer on 7/9/2017.
 * 206. Reverse Linked List
 * Reverse a singly linked list.
 */
public class p206 {
    public ListNode reverseList(ListNode head) {
        if (head == null) return null;
        if (head.next == null) return head;
        ListNode currHead = reverseList(head.next);
        ListNode currNext = head.next;
        currNext.next = head;
        return currHead;
    }
}
