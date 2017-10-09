import java.util.*;

/**
 * Created by Valued Customer on 09/27/2017.
 * 207. Course Schedule
 *
 */
public class p207 {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if (prerequisites == null || prerequisites.length == 0) return true;
        Map<Integer, Set<Integer>> map = new HashMap<>();
        for (int[] prereq : prerequisites) {
            map.putIfAbsent(prereq[0], new HashSet<>());
            map.get(prereq[0]).add(prereq[1]);
        }
        boolean[][] visited = new boolean[numCourses][2];
        for (int i = 0; i < numCourses; i++) {
            if (dfs(map, visited, i)) return false;
        }
        return true;
    }

    private boolean dfs(Map<Integer, Set<Integer>> map, boolean[][] visited, int n) {
        visited[n][0] = true;
        visited[n][1] = true;
        if (map.containsKey(n)) {
            for (int neighbor : map.get(n)) {
                if (!visited[neighbor][0] && dfs(map, visited, neighbor))
                    return true;
                if (visited[neighbor][1]) return true;
            }
        }

        visited[n][1] = false;
        return false;
    }
}
