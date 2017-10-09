import java.util.*;

/**
 * Created by Larry Liu on 9/28/2017.
 * 210. Course Schedule II
 */
public class p210 {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] order = new int[numCourses];
        Map<Integer, Set<Integer>> map = new HashMap<>();
        boolean[] added = new boolean[numCourses];
        for (int[] prereq : prerequisites) {
            map.putIfAbsent(prereq[1], new HashSet<>());
            map.get(prereq[1]).add(prereq[0]);
            added[prereq[1]] = true;
            added[prereq[0]] = true;
        }
        for (int i = 0; i < numCourses; i++) if (!added[i]) map.putIfAbsent(i, new HashSet<>());
        boolean[][] visited = new boolean[numCourses][2];

        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < numCourses; i++) {
            if (!visited[i][0] && dfs(map, visited, stack, i)) return null;
        }
        for (int i = 0; i < numCourses; i++) {
            order[i] = stack.pop();
        }
        return order;
    }

    private boolean dfs(Map<Integer, Set<Integer>> map, boolean[][] visited, Stack<Integer> stack, int n) {
        visited[n][0] = true;
        visited[n][1] = true;
        if (map.containsKey(n)) {
            for (int neighbor : map.get(n)) {
                if (!visited[neighbor][0] && dfs(map, visited, stack, neighbor))
                    return true;
                if (visited[neighbor][1]) return true;
            }
        }
        stack.push(n);
        visited[n][1] = false;
        return false;
    }

    public static void main(String[] args) {
        p210 sol = new p210();
        sol.findOrder(2, new int[][]{{1, 0}});
    }
}
