import java.util.HashMap;
import java.util.Map;

/**
 * Created by Valued Customer on 7/5/2017.
 * 138. Copy List with Random Pointer
 *
 * A linked list is given such that each node contains an additional random pointer which could point to any node in the
 * list or null.

 Return a deep copy of the list.
 */
public class p138 {
    class RandomListNode {
        int label;
        RandomListNode next, random;
        RandomListNode(int x) { this.label = x; }
    }

    public RandomListNode copyRandomList(RandomListNode head) {
        if (head == null) return null;
        Map<RandomListNode, RandomListNode> map = new HashMap<>();
        RandomListNode iter = head;
        map.put(head, new RandomListNode(head.label));
        RandomListNode copyIter = map.get(head);
        while (iter.next != null) {
            copyIter.next = new RandomListNode(iter.next.label);
            map.put(iter.next, copyIter.next);
            iter = iter.next;
            copyIter = copyIter.next;
        }

        iter = head;
        while (iter != null) {
            if (iter.random != null) {
                map.get(iter).random = map.get(iter.random);
            }
            iter = iter.next;
        }
        return map.get(head);
    }
}
