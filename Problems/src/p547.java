/**
 * Created by Valued Customer on 7/13/2017.
 * 547. Friend Circles
 *
 */
public class p547 {

    public int findCircleNum(int[][] M) {
        boolean[] visited = new boolean[M.length];
        int count = 0;
        for (int i = 0; i < visited.length; i++) {
            if (visited[i]) continue;
            count++;
            bfs(M, visited, i);
        }
        return count;
    }

    private void bfs(int[][] M, boolean[] visited, int i) {
        if (visited[i]) return;
        visited[i] = true;
        int[] neighbors = M[i];
        for (int j = 0; j < neighbors.length; j++) {
            if (j == i) continue;
            if (neighbors[j] == 1) bfs(M, visited, j);
        }
    }
}
