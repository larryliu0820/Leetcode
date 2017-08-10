import java.util.PriorityQueue;

/**
 * Created by Valued Customer on 7/29/2017.
 * 23. Merge k Sorted Lists
 */
public class p023 {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) return null;
        PriorityQueue<ListNode> pq = new PriorityQueue<>((i,j)->i.val - j.val);
        for (ListNode node: lists) if (node != null) pq.offer(node);
        ListNode root = new ListNode(0);
        ListNode itr = root;
        while (!pq.isEmpty()) {
            itr.next = pq.poll();
            itr = itr.next;
            if (itr.next != null) pq.offer(itr.next);
        }
        return root.next;
    }
}
