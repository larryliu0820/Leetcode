import java.util.Random;

/**
 * Created by Valued Customer on 9/8/2016.
 * 382. Linked List Random Node
 * Given a singly linked list, return a random node's value from the linked list. Each node must have the same probability of being chosen.

 Follow up:
 What if the linked list is extremely large and its length is unknown to you? Could you solve this efficiently without using extra space?

 Example:

 // Init a singly linked list [1,2,3].
 ListNode head = new ListNode(1);
 head.next = new ListNode(2);
 head.next.next = new ListNode(3);
 Solution solution = new Solution(head);

 // getRandom() should return either 1, 2, or 3 randomly. Each element should have equal probability of returning.
 solution.getRandom();
 Show Company Tags
 Show Tags

 */
public class p382 {
    ListNode head;

    /** @param head The linked list's head.
    Note that the head is guaranteed to be not null, so it contains at least one node. */
    public p382(ListNode head) {
        this.head = head;
    }

    /** Returns a random node's value. */
    public int getRandom() {
        Random rand = new Random();
        int count = 0;
        ListNode node = head;
        ListNode candidate = head;
        while (node != null) {
            if (rand.nextInt(count + 1) == count) candidate = node;
            node = node.next;
            count++;
        }
        return candidate.val;
    }
}
