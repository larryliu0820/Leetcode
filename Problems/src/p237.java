/**
 * Created by Valued Customer on 7/27/2017.
 * 237. Delete Node in a Linked List
 */
public class p237 {
    public void deleteNode(ListNode node) {
        while (node.next.next != null) {
            node.val = node.next.val;
            node = node.next;
        }
        node.val = node.next.val;
        node.next = null;
    }
}
