import java.util.*;

/**
 * Created by Valued Customer on 7/25/2017.
 * 218. The Skyline Problem
 */
public class p218 {
    class Edge implements Comparable<Edge>{
        int x;
        int h;
        boolean isUp;
        Edge(int x, int h, boolean isUp) {
            this.x = x;
            this.h = h;
            this.isUp = isUp;
        }
        @Override
        public int compareTo(Edge e1) {
            if (x != e1.x)
                return x - e1.x;
            if (isUp ^ e1.isUp)
                return isUp?-1:1;

            return isUp?e1.h - h:h-e1.h;
        }
    }
    public List<int[]> getSkyline(int[][] buildings) {
        List<int[]> result = new LinkedList<>();
        if (buildings == null || buildings.length == 0|| buildings[0].length == 0) return result;
        List<Edge> edges = new LinkedList<>();
        PriorityQueue<Edge> pq = new PriorityQueue<>((edge, t1) -> t1.h - edge.h);
        Map<Edge, Edge> map = new HashMap<>();
        for (int[] building: buildings) {
            Edge e1 = new Edge(building[0], building[2], true);
            Edge e2 = new Edge(building[1], building[2], false);
            edges.add(e1);
            edges.add(e2);
            map.put(e2, e1);
        }
        Collections.sort(edges);
        for (Edge e : edges) {
            if (e.isUp) {
                int currHeight = pq.isEmpty()?0:pq.peek().h;
                if (e.h > currHeight) result.add(new int[]{e.x, e.h});
                pq.offer(e);
            } else if (!pq.isEmpty() && !e.isUp) {
                Edge up = map.get(e);
                int prev = pq.peek().h;
                pq.remove(up);
                int currHeight = pq.isEmpty()?0:pq.peek().h;
                if (currHeight < prev) result.add(new int[]{e.x, currHeight});
            }
        }
        return result;
    }

}
