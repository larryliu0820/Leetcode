import java.util.*;

/**
 * Created by Valued Customer on 7/19/2017.
 * 207. Course Schedule
 *
 */
public class p207 {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if (prerequisites == null || prerequisites.length == 0 || prerequisites[0].length == 0) return true;
        Map<Integer, List<Integer>> adjacencyList = new HashMap<>();

        for (int i = 0; i < prerequisites.length; i++) {
            adjacencyList.putIfAbsent(prerequisites[i][0], new ArrayList<>());
            adjacencyList.get(prerequisites[i][0]).add(prerequisites[i][1]);
        }

        boolean[] visited = new boolean[numCourses];
        for (int key : adjacencyList.keySet())
            if (!dfs(adjacencyList, visited, key)) return false;
        return true;
    }

    private boolean dfs(Map<Integer, List<Integer>> map, boolean[] visited, int curr) {
        if (visited[curr]) return false;
        List<Integer> neighbors = map.get(curr);
        if (neighbors == null) return true;
        visited[curr] = true;

        for (int neighbor : neighbors) {
            boolean ret = dfs(map, visited, neighbor);
            if (!ret) return false;
        }
        visited[curr] = false;
        map.put(curr, null);
        return true;
    }
}
