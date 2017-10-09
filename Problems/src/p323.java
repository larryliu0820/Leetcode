import java.util.*;

/**
 * Created by Valued Customer on 9/16/2016.
 * 323. Number of Connected Components in an Undirected Graph
 * Given n nodes labeled from 0 to n - 1 and a list of undirected edges (each edge is a pair of nodes), write a function
 * to find the number of connected components in an undirected graph.

 Example 1:
 0          3
 |          |
 1 --- 2    4
 Given n = 5 and edges = [[0, 1], [1, 2], [3, 4]], return 2.

 Example 2:
 0           4
 |           |
 1 --- 2 --- 3
 Given n = 5 and edges = [[0, 1], [1, 2], [2, 3], [3, 4]], return 1.

 Note:
 You can assume that no duplicate edges will appear in edges. Since all edges are undirected, [0, 1] is the same as [1, 0]
 and thus will not appear together in edges.
 */
public class p323 {
    private int[] father;
    public int countComponents(int n, int[][] edges) {
        father = new int[n];
        for (int i = 0; i < n; i++) father[i] = i;
        for (int[] edge : edges) {
            union(edge[0], edge[1]);
        }
        Set<Integer> res = new HashSet<>();
        int last = -1;
        for (int i = 0; i < n; i++) {
            int f = find(i);
            if (f != last) {
                res.add(f);
                last = f;
            }
        }
        return res.size();
    }

    private int find(int i) {
        while (father[i] != i) {
            father[i] = father[father[i]];
            i = father[i];
        }
        return father[i];
    }

    private void union(int i, int j) {
        int f1 = find(i);
        int f2 = find(j);
        if (f1 != f2) father[f1] = f2;
    }

    public static void main(String[] args) {
        p323 sol = new p323();
        sol.countComponents(5, new int[][]{{0,1}, {0,4}, {1,4}, {2,3}});
    }
}
