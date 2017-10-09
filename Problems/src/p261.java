import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by Larry Liu on 10/1/2017.
 * 261. Graph Valid Tree
 */
public class p261 {
    public boolean validTree(int n, int[][] edges) {
        Map<Integer, Set<Integer>> map = new HashMap<>();
        for (int i = 0; i < n; i++) map.put(i, new HashSet<>());
        for (int[] edge: edges) {
            map.get(edge[0]).add(edge[1]);
            map.get(edge[1]).add(edge[0]);
        }
        boolean[] visited = new boolean[n];
        if ((!visited[0]) && dfs(map, visited, 0, -1)) return false;
        for (int i = 0; i < n; i++) {
            if (!visited[i]) return false;
        }
        return true;
    }
    private boolean dfs(Map<Integer, Set<Integer>> map, boolean[] visited, int curr, int parent) {
        visited[curr] = true;
        for (int neighbor : map.get(curr)) {
            if (!visited[neighbor]) {
                if (dfs(map, visited, neighbor, curr)) return true;
            } else if (neighbor != parent) return true;
        }
        return false;
    }

    public static void main(String[] args) {
        p261 sol = new p261();
        sol.validTree(4, new int[][] {{0,1}, {2,3}});
    }
}
