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
        ListNode itr1 = headA, itr2 = headB;
        while (itr1.next != null && itr2.next != null) {
            itr1 = itr1.next;
            itr2 = itr2.next;
        }
        ListNode itr3 = itr1.next!=null?headA:headB;
        ListNode itr4 = itr3==headA?headB:headA;
        ListNode endItr = itr1.next!=null?itr1:itr2;
        while (endItr.next != null) {
            itr3 = itr3.next;
            endItr = endItr.next;
        }
        while (itr3 != null && itr4 != null) {
            if (itr3 == itr4) return itr3;
            itr3 = itr3.next;
            itr4 = itr4.next;
        }
        return null;
    }
}
