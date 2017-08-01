/**
 * Created by Valued Customer on 7/27/2017.
 * 237. Delete Node in a Linked List
 */
public class p237 {
    public void deleteNode(ListNode node) {
        ListNode n = node.next;
        while (n != null) {
            node.val = n.val;
            if (n.next == null) {
                node.next = null;
                break;
            }
            else {
                node = node.next;
                n = n.next;
            }

        }
    }
}
