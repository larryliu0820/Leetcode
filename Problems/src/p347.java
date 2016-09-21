import java.util.*;

/**
 * Created by Valued Customer on 9/21/2016.
 * 347. Top K Frequent Elements
 * Given a non-empty array of integers, return the k most frequent elements.

 For example,
 Given [1,1,1,2,2,3] and k = 2, return [1,2].

 Note:
 You may assume k is always valid, 1 ≤ k ≤ number of unique elements.
 Your algorithm's time complexity must be better than O(n log n), where n is the array's size.
 */
public class p347 {
    public List<Integer> topKFrequent(int[] nums, int k) {

        PriorityQueue<int[]> pq = new PriorityQueue<> (new Comparator<int[]> () {
            @Override
            public int compare(int[] i, int[] j) {
                return j[1] - i[1];
            }
        });
        Map<Integer,Integer> map = new HashMap<>();
        for (int i : nums) {
            if (map.containsKey(i)) map.put(i, map.get(i)+1);
            else map.put(i, 1);
        }
        for (int key : map.keySet()) {
            pq.offer(new int[]{key, map.get(key)});
        }

        List<Integer> result = new LinkedList<>();
        for (int i = 0; i < k; i++) {
            result.add(pq.poll()[0]);
        }
        return result;
    }
}
