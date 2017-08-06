import java.util.*;

/**
 * Created by Valued Customer on 7/25/2017.
 * 218. The Skyline Problem
 */
public class p218 {
    class Edge {
        int x;
        int h;
        boolean isUp;
        public Edge(int p, int h, boolean u) {
            x = p;
            this.h = h;
            isUp = u;
        }
    }

    public List<int[]> getSkyline(int[][] buildings) {
        List<Edge> list = new LinkedList<>();
        PriorityQueue<Edge> pq = new PriorityQueue<>(new Comparator<Edge>() {
            @Override
            public int compare(Edge edge, Edge t1) {
                return t1.h - edge.h;
            }
        });
        Map<Edge, Edge> map = new HashMap<>();
        for (int[] building : buildings) {
            Edge e1 = new Edge(building[0], building[2], true);
            list.add(e1);
            Edge e2 = new Edge(building[1], building[2], false);
            list.add(e2);
            map.put(e2, e1);
        }

        Collections.sort(list, new Comparator<Edge>() {
            @Override
            public int compare(Edge edge, Edge t1) {
                if (edge.x == t1.x) {
                    if (edge.isUp ^ t1.isUp) return edge.isUp?-1:1;
                    return edge.isUp?(t1.h-edge.h):(edge.h-t1.h);
                }
                return edge.x - t1.x;
            }
        });
        List<int[]> result = new ArrayList<>();
        for (Edge e : list) {
            if (e.isUp) {
                int currHeight = pq.isEmpty()?0:pq.peek().h;
                if (e.h > currHeight) {
                    result.add(new int[]{e.x, e.h});
                }
                pq.offer(e);
            } else if (!pq.isEmpty() && !e.isUp) {
                Edge up = map.get(e);
                int prev = pq.peek().h;
                pq.remove(up);
                int currHeight = pq.isEmpty()?0:pq.peek().h;
                if (currHeight < prev) {
                    result.add(new int[]{e.x, currHeight});
                }
            }
        }

        return result;
    }

}
