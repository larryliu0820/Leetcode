import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by Larry Liu on 10/2/2017.
 * 685. Redundant Connection II
 */
public class p685 {
    int[] result = null;
    public int[] findRedundantDirectedConnection(int[][] edges) {
        Map<Integer, Set<Integer>> map = new HashMap<>();
        // check indegree
        int[] indeg = new int[edges.length+1];
        Set<Integer> res = new HashSet<>();
        for (int[] edge: edges) {
            map.putIfAbsent(edge[0], new HashSet<>());
            map.putIfAbsent(edge[1], new HashSet<>());
            map.get(edge[0]).add(edge[1]);
            indeg[edge[1]]++;
            if (indeg[edge[1]] > 1) res.add(edge[1]);
        }
        boolean[][] visited = new boolean[2][map.keySet().size() + 1];
        for (int i = 1; i < map.keySet().size() + 1; i++) if (!visited[0][i]) dfs(map, visited, i);
        // 3 conditions
        if (result != null) {
            if (res.size() == 0) return result;
            else {
                Set<Integer> loop = new HashSet<>();
                while (!loop.contains(result[1])) {
                    loop.add(result[1]);
                    result[0] = result[1];
                    result[1] = map.get(result[1]).iterator().next();
                    if (res.contains(result[1])) return result;
                }
            }
        } else {
            if (res.size() != 0) {
                for (int i = edges.length - 1; i >= 0; i--) {
                    if (res.contains(edges[i][1])) {
                        return edges[i];
                    }
                }
            }
        }
        return null;
    }

    private void dfs(Map<Integer, Set<Integer>> map, boolean[][] visited, int curr) {
         visited[0][curr] = true;
         visited[1][curr] = true;
         for (int neighbor: map.get(curr)) {
             if (visited[1][neighbor]) {
                 result = new int[]{curr, neighbor};
                 return;
             } else if (!visited[0][neighbor]) {
                 dfs(map, visited, neighbor);
             }
         }
         visited[1][curr] = false;
    }

    public static void main(String[] args) {
        p685 sol = new p685();
        int[] result = sol.findRedundantDirectedConnection(new int[][]{{11,3},{7,15},{24,9},{22,13},{4,17},{2,16},{21,6},{11,24},{8,22},{2,12},{23,1},{6,18},{10,20},{20,8},{6,25},{25,14},{2,11},{14,10},{8,5},{7,4},{5,11},{20,7},{24,21},{4,23},{21,19}});
        System.out.println(result[0]);
    }
}
