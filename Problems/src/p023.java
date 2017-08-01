import java.util.PriorityQueue;

/**
 * Created by Valued Customer on 7/29/2017.
 * 23. Merge k Sorted Lists
 */
public class p023 {
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> pq = new PriorityQueue<>((i, j)->i.val - j.val);
        for (ListNode n: lists)
            if (n != null) pq.offer(n);
        ListNode result = new ListNode(0);
        ListNode itr = result;
        while (!pq.isEmpty()) {
            ListNode curr = pq.poll();
            itr.next = new ListNode(curr.val);
            if (curr.next != null) pq.offer(curr.next);
            itr = itr.next;
        }
        return result.next;
    }
}
