import java.util.*;

/**
 * Created by Valued Customer on 9/29/2017.
 * 310. Minimum Height Trees
 */
public class p310 {
    class Node {
        int id;
        Set<Node> neighbors;
        Node(int id) {
            this.id = id;
            this.neighbors = new HashSet<>();
        }
    }
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        // adjacency list
        Map<Integer, Node> map = new HashMap<>();
        List<Integer> res = new LinkedList<>();
        for (int i = 0; i < n; i++) map.put(i, new Node(i));
        for (int[] edge: edges) {
            map.get(edge[0]).neighbors.add(map.get(edge[1]));
            map.get(edge[1]).neighbors.add(map.get(edge[0]));
        }
        PriorityQueue<Node> pq = new PriorityQueue<>(Comparator.comparingInt(node->node.neighbors.size()));
        pq.addAll(map.values());
        while (pq.size() > 2) {
            List<Node> leafs = new LinkedList<>();
            while (!pq.isEmpty() && pq.peek().neighbors.size() == 1) leafs.add(pq.poll());
            for (Node leaf: leafs) {
                Iterator<Node> itr = leaf.neighbors.iterator();
                Node neighbor = itr.next();
                pq.remove(neighbor);
                neighbor.neighbors.remove(leaf);
                pq.offer(neighbor);
            }

        }
        while (!pq.isEmpty()) res.add(pq.poll().id);
        return res;
    }

    public static void main(String[] args) {
        p310 sol = new p310();
        int[][] edges = new int[][] {{0,1},{1,2},{2,3},{0,4},{4,5},{4,6},{6,7}};
        sol.findMinHeightTrees(8, edges);
    }
}
