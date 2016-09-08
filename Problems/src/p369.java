/**
 * Created by mengwliu on 9/7/16.
 * 369. Plus One Linked List
 * Given a non-negative number represented as a singly linked list of digits, plus one to the number.

 The digits are stored such that the most significant digit is at the head of the list.

 Example:

 Input:
 1->2->3

 Output:
 1->2->4

 */
public class p369 {
    public ListNode plusOne(ListNode head) {
        int carry = helper(head);
        if ( carry == 1) {
            ListNode h = new ListNode(1);
            h.next = head;
            return h;
        } else {
            return head;
        }
    }

    public int helper(ListNode head) {
        if (head == null) {
            return 1;
        }

        int carry = helper(head.next);
        if (carry == 1) {
            if (head.val == 9) {
                head.val = 0;
                return 1;
            } else {
                head.val++;
                return 0;
            }
        }
        return 0;
    }
}
