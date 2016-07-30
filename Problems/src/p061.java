/**
 * Created by mengwliu on 7/29/16.
 * 61. Rotate List
 * Given a list, rotate the list to the right by k places, where k is non-negative.

 For example:
 Given 1->2->3->4->5->NULL and k = 2,
 return 4->5->1->2->3->NULL.
 */

import com.sun.xml.internal.bind.v2.schemagen.xmlschema.List;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class p061 {
    public static class ListNode {
         int val;
         ListNode next;
         ListNode(int x) { val = x; }
    }
    public ListNode rotateRight(ListNode head, int k) {
        ListNode itr = head;
        int i = 0;
        while (i < k) {
            if (itr.next == null) return head;
            itr = itr.next;
            i++;
        }
        if (itr == null || itr.next == null) return head;
        ListNode newHead = itr.next;
        //System.out.println("itr.val = " + itr.val + " itr.next.val = " + itr.next.val);
        itr.next = null;
        itr = newHead;
        while (itr.next != null) itr = itr.next;
        itr.next = head;
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
        ListNode newHead = sol.rotateRight(head, 0);

        itr = newHead;
        System.out.print("itr = ");
        while(itr != null) {
            System.out.print(itr.val + "->");
            itr = itr.next;
        }
        System.out.print("null\n");
    }
}
