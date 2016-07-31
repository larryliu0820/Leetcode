/**
 * Created by mengwliu on 7/29/16.
 * 61. Rotate List
 * Given a list, rotate the list to the right by k places, where k is non-negative.

 For example:
 Given 1->2->3->4->5->NULL and k = 2,
 return 4->5->1->2->3->NULL.
 */
public class p061 {
    public static class ListNode {
         int val;
         ListNode next;
         ListNode(int x) { val = x; }
    }
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null) return null;
        ListNode itrA = head;
        ListNode itrB = head;
        int i = 0;
        while (i < k) {
            if (itrB.next == null) {
                k = k % (i+1);
                i = 0;
                itrB = head;
            } else {
                itrB = itrB.next;
                i++;
            }
        }
        while (itrB.next != null) {
            itrA = itrA.next;
            itrB = itrB.next;
        }

        if (itrA.next == null) return head;
        ListNode newHead = itrA.next;
        itrA.next = null;
        itrB.next = head;
        //System.out.println("itr.val = " + itr.val + " itr.next.val = " + itr.next.val);
        return newHead;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode node = head;
        for (int i = 2; i < 3; i++) {
            node.next = new ListNode(i);
            node = node.next;
        }
        ListNode itr = head;
        System.out.print("itr = ");
        while(itr != null) {
            System.out.print(itr.val + "->");
            itr = itr.next;
        }
        System.out.print("null\n");

        p061 sol = new p061();
        ListNode newHead = sol.rotateRight(head, 1);

        itr = newHead;
        System.out.print("itr = ");
        while(itr != null) {
            System.out.print(itr.val + "->");
            itr = itr.next;
        }
        System.out.print("null\n");
    }
}
