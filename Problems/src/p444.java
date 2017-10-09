import java.util.*;

/**
 * Created by Larry Liu on 10/4/2017.
 * 444. Sequence Reconstruction
 */
public class p444 {
    public boolean sequenceReconstruction2(int[] org, List<List<Integer>> seqs) {
        int[] indeg = new int[org.length+1];
        Map<Integer, Set<Integer>> map = new HashMap<>();
        for (List<Integer> seq: seqs) {
            if(seq.size() == 1) {
                if(!map.containsKey(seq.get(0))) {
                    map.put(seq.get(0), new HashSet<>());
                }
            } else {
                for(int i = 0; i < seq.size() - 1; i++) {
                    if (seq.get(i) >= indeg.length ||
                            seq.get(i) < 0 ||
                            seq.get(i+1) >= indeg.length ||
                            seq.get(i+1) < 0) return false;
                    if(!map.containsKey(seq.get(i))) {
                        map.put(seq.get(i), new HashSet<>());
                    }

                    if(!map.containsKey(seq.get(i+1))) {
                        map.put(seq.get(i+1), new HashSet<>());
                    }

                    if(map.get(seq.get(i)).add(seq.get(i+1))) {
                        indeg[seq.get(i+1)]++;
                    }
                }
            }

        }
        Queue<Integer> q = new LinkedList<>();
        for (int node = 1; node < indeg.length; node++) {
            if (indeg[node] == 0) q.offer(node);
        }
        int index = 0;
        while (!q.isEmpty()) {
            if (q.size() > 1) return false;
            int curr = q.poll();
            if (index == org.length || curr != org[index++]) return false;
            for (int neighbor: map.get(curr)) {
                indeg[neighbor]--;
                if (indeg[neighbor] == 0) q.offer(neighbor);
            }
        }
        return index == org.length && index == map.size();
    }

    public boolean sequenceReconstruction(int[] org, List<List<Integer>> seqs) {
        // check out degree first
        int[] outdeg = new int[org.length+1];
        Map<Integer, Set<Integer>> map = new HashMap<>();
        for (int i = 0; i < outdeg.length; i++) map.putIfAbsent(i, new HashSet<>());
        for (List<Integer> seq: seqs) {
            if (seq.size() != 2 ||
                    seq.get(0) >= outdeg.length ||
                    seq.get(0) < 0 ||
                    seq.get(1) >= outdeg.length ||
                    seq.get(1) < 0) continue;
            outdeg[seq.get(0)]++;
            map.get(seq.get(0)).add(seq.get(1));
        }
        int zeros = 0;
        for (int i = 1; i < outdeg.length; i++) if (outdeg[i] == 0) zeros++;
        boolean[][] visited = new boolean[2][org.length+1];
        Stack<Integer> result = new Stack<>();
        if (zeros == 1) {
            if (topoSort(map, visited, result, org[0])) return false;
            for (int i = 1; i < visited[0].length; i++) if (!visited[0][i]) return false;
            for (int i: org) {
                if (result.isEmpty()) return false;
                int other = result.pop();
                if (i != other) return false;
            }
            return true;
        }
        return false;
    }

    public boolean topoSort(Map<Integer, Set<Integer>> map, boolean[][] visited, Stack<Integer> stack, int curr) {
        if (!visited[0][curr]) {
            visited[0][curr] = true;
            visited[1][curr] = true;
            for (int neighbor : map.get(curr)) {
                if (!visited[0][neighbor] && topoSort(map, visited, stack, neighbor)) return true;
                else if (visited[1][neighbor]) return true;
            }
            stack.push(curr);
        }
        visited[1][curr] = false;
        return false;
    }

    public static void main(String[] args) {
        p444 sol = new p444();
        List<List<Integer>> seqs = new LinkedList<>();
        List<Integer> seq1 = new LinkedList<>();
        seq1.add(1);
        seq1.add(2);
        List<Integer> seq2 = new LinkedList<>();
        seq2.add(1);
        seq2.add(2);
        List<Integer> seq3 = new LinkedList<>();
        seq3.add(2);
        seq3.add(3);
        seqs.add(seq1);
        seqs.add(seq2);
//        seqs.add(seq3);
        System.out.println(sol.sequenceReconstruction2(new int[]{1,2}, seqs));
    }
}
