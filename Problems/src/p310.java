import java.util.*;

/**
 * Created by Valued Customer on 7/19/2017.
 * 310. Minimum Height Trees
 */
public class p310 {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        if (edges == null) return null;
        Map<Integer, Set<Integer>> adjacencyList = new HashMap<>();

        for (int i = 0; i < edges.length; i++) {
            adjacencyList.putIfAbsent(edges[i][0], new HashSet<>());
            adjacencyList.get(edges[i][0]).add(edges[i][1]);
            adjacencyList.putIfAbsent(edges[i][1], new HashSet<>());
            adjacencyList.get(edges[i][1]).add(edges[i][0]);
        }

        List<Integer> leafs = new ArrayList<>();
        for (int i : adjacencyList.keySet()) {
            if (adjacencyList.get(i).size() == 1) leafs.add(i);
        }


        while (n > leafs.size()) {
            n -= leafs.size();
            List<Integer> newLeafs = new ArrayList<>();
            for (int i: leafs) {
                int j = adjacencyList.get(i).iterator().next();
                adjacencyList.get(j).remove(i);
                if (adjacencyList.get(j).size() == 1) newLeafs.add(j);
            }
            leafs = newLeafs;
        }
        return leafs;
    }

    public static void main(String[] args) {
        p310 sol = new p310();
        int[][] edges = new int[][] {{0,1},{1,2},{2,3},{0,4},{4,5},{4,6},{6,7}};
        sol.findMinHeightTrees(8, edges);
    }
}
