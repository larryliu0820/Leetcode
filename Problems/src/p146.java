import java.util.HashMap;
import java.util.Map;

/**
 * Created by Valued Customer on 9/21/2016.
 * 146. LRU Cache
 * Design and implement a data structure for Least Recently Used (LRU) cache. It should support the following operations: get and set.

 get(key) - Get the value (will always be positive) of the key if the key exists in the cache, otherwise return -1.
 set(key, value) - Set or insert the value if the key is not already present. When the cache reached its capacity, it
 should invalidate the least recently used item before inserting a new item.
 */
public class p146 {
    class DListNode {
        DListNode prev, next;
        int key,val;
        DListNode() {}
        DListNode(int k, int v) { key = k; val = v; }
    }
    DListNode head;
    DListNode tail;
    int CAPACITY;
    Map<Integer, DListNode> map;
    public p146(int capacity) {
        CAPACITY = capacity;
        head = new DListNode();
        tail = new DListNode();
        head.next = tail;
        tail.prev = head;
        map = new HashMap<>();
    }

    public int get(int key) {
        if (map.containsKey(key)) {
            DListNode node = map.get(key);
            remove(node);
            insert(node);
            return node.val;
        } else return -1;
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            get(key);
            map.get(key).val = value;
        } else {
            if (map.keySet().size() >= CAPACITY) {
                map.remove(head.next.key);
                remove(head.next);
            }
            DListNode node = new DListNode(key, value);
            insert(node);
            map.put(key, node);
        }
    }

    private void remove(DListNode node) {
        DListNode prev = node.prev;
        DListNode next = node.next;
        node.next = null;
        node.prev = null;
        prev.next = next;
        next.prev = prev;
    }

    private void insert(DListNode node) {
        DListNode next = tail;
        DListNode prev = tail.prev;
        next.prev = node;
        prev.next = node;
        node.prev = prev;
        node.next = next;
    }

    public static void main(String[] args) {
        p146 sol = new p146(2);
        sol.get(2);
        sol.put(1,1);
        sol.put(2,2);
        sol.get(1);
        sol.put(3,3);
        sol.get(2);
        sol.put(4,4);
        sol.get(1);
        sol.get(3);
        sol.get(4);
    }
}
