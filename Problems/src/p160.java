/**
 * Created by Valued Customer on 8/11/2016.
 * 160. Intersection of Two Linked Lists
 * Write a program to find the node at which the intersection of two singly linked lists begins.


 For example, the following two linked lists:

 A:          a1 → a2
                    ↘
                      c1 → c2 → c3
                    ↗
 B:     b1 → b2 → b3
 begin to intersect at node c1.


 Notes:

 If the two linked lists have no intersection at all, return null.
 The linked lists must retain their original structure after the function returns.
 You may assume there are no cycles anywhere in the entire linked structure.
 Your code should preferably run in O(n) time and use only O(1) memory.
 */
public class p160 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) return null;
        ListNode itrA = headA, itrB = headB;
        while (itrA.next != null && itrB.next != null) {
            itrA = itrA.next;
            itrB = itrB.next;
        }

        ListNode end = itrA.next == null?itrB:itrA;
        ListNode begin = itrA.next == null?headB:headA;

        while (end.next != null) {
            end = end.next;
            begin = begin.next;
        }

        ListNode itr = itrA.next == null?headA:headB;

        while(itr != null && begin != null) {
            if (itr == begin) return itr;
            itr = itr.next;
            begin = begin.next;
        }
        return null;
    }
}
