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

        RandomListNode(int x) {
            this.label = x;
        }
    }
    public RandomListNode copyRandomList(RandomListNode head) {
        if (head == null) return null;
        Map<RandomListNode, RandomListNode> map = new HashMap<>();
        RandomListNode itr = head;
        while (itr != null) {
            map.put(itr, new RandomListNode(itr.label));
            itr = itr.next;
        }
        itr = head;
        while (itr != null) {
            RandomListNode node = map.get(itr);
            node.next = map.get(itr.next);
            node.random = map.get(itr.random);
            itr = itr.next;
        }
        return map.get(head);
    }
}
