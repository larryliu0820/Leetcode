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
        ListNode oldNext = head.next;
        ListNode tail = reverseList(oldNext);
        oldNext.next = head;
        head.next = null;
        return tail;
    }

    public ListNode reverseList2(ListNode head) {
        if (head == null) return null;
        if (head.next == null) return head;
        Stack<ListNode> stack = new Stack<>();
        ListNode itr = head;
        while (itr != null) {
            stack.push(itr);
            itr = itr.next;
        }
        ListNode tail = stack.pop();
        ListNode prev = tail;
        while (!stack.isEmpty()) {
            itr = stack.pop();
            prev.next = itr;
            itr.next = null;
            prev = itr;
        }
        prev.next = null;
        return tail;
    }
}
