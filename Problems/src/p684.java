import java.util.*;

/**
 * Created by Larry Liu on 10/5/2017.
 * 684. Redundant Connection
 */
public class p684 {
    public int[] findRedundantConnection(int[][] edges) {
        Map<Integer, Set<Integer>> map = new HashMap<>();
        for (int[] edge: edges) {
            map.putIfAbsent(edge[0], new HashSet<>());
            map.putIfAbsent(edge[1], new HashSet<>());
            map.get(edge[0]).add(edge[1]);
            map.get(edge[1]).add(edge[0]);
        }

        boolean[] visited = new boolean[map.keySet().size()+1];
        List<Integer> res = new LinkedList<>();
        dfs(map, visited, res, 1, -1);
        for (int i = edges.length-1; i >= 0; i--) {
            int[] edge = edges[i];
            if (res.contains(edge[0]) && res.contains(edge[1])) return edge;
        }
        return null;
    }

    private boolean dfs(Map<Integer, Set<Integer>> map, boolean[] visited, List<Integer> res, int curr, int parent) {
        visited[curr] = true;
        for (int neighbor: map.get(curr)) {
            if (visited[neighbor]) {
                if (neighbor != parent) {
                    res.add(neighbor);
                    res.add(curr);
                    return false;
                }
            } else {
                if (!dfs(map, visited, res, neighbor, curr)) {
                    if (res.contains(curr)) return true;
                    res.add(curr);
                    return false;
                }
            }
        }
        return true;
    }
}
