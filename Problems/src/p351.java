import java.util.LinkedList;
import java.util.List;

/**
 * Created by mengwliu on 9/6/16.
 * 351. Android Unlock Patterns
 *  Given an Android 3x3 key lock screen and two integers m and n, where 1 ≤ m ≤ n ≤ 9, count the total number of unlock
 *  patterns of the Android lock screen, which consist of minimum of m keys and maximum n keys.

 Rules for a valid pattern:

 Each pattern must connect at least m keys and at most n keys.
 All the keys must be distinct.
 If the line connecting two consecutive keys in the pattern passes through any other keys, the other keys must have
 previously selected in the pattern. No jumps through non selected key is allowed.
 The order of keys used matters.

 Explanation:

 | 1 | 2 | 3 |
 | 4 | 5 | 6 |
 | 7 | 8 | 9 |

 Invalid move: 4 - 1 - 3 - 6
 Line 1 - 3 passes through key 2 which had not been selected in the pattern.

 Invalid move: 4 - 1 - 9 - 2
 Line 1 - 9 passes through key 5 which had not been selected in the pattern.

 Valid move: 2 - 4 - 1 - 3 - 6
 Line 1 - 3 is valid because it passes through key 2, which had been selected in the pattern

 Valid move: 6 - 5 - 4 - 1 - 9 - 2
 Line 1 - 9 is valid because it passes through key 5, which had been selected in the pattern.

 Example:
 Given m = 1, n = 1, return 9.
 */
public class p351 {
    public int numberOfPatterns(int m, int n) {
        List<List<Integer>> result = new LinkedList<>();
        boolean[] visited = new boolean[9];
        List<Integer> current = new LinkedList<>();
        helper(result, visited, current, 0, m, n);
        return result.size();
    }

    public void helper(List<List<Integer>> result, boolean[] visited, List<Integer> current, int i, int m, int n) {
        if (i > n) return;
        if (i >= m && i <= n) {
            result.add(new LinkedList<>(current));
        }
        if (i == 0) {
            for (int j = 1; j <= 9; j++) {
                visited[j] = true;
                current.add(j);
                helper(result, visited, current, i+1, m, n);
                current.remove(current.size()-1);
                visited[j] = false;
            }
            return;
        }
        int last = current.get(current.size()-1);
        List<Integer> neighbors = new LinkedList<>();
        getNeighbors(neighbors, visited, last);
        for (int k : neighbors) {
            current.add(k);
            visited[k] = true;
            helper(result, visited, current, i+1, m, n);
            visited[k] = false;
            current.remove(current.size()-1);
        }
    }

    public void getNeighbors(List<Integer> neighbors, boolean[] visited, int last) {
        switch (last) {
            case 1: {
                int[][] pairs = new int[3][];
                pairs[0] = new int[]{2,3};
                pairs[1] = new int[]{5,9};
                pairs[2] = new int[]{4,7};
                addNeighbors(neighbors,visited,pairs);
                break;
            }
            case 2: {
                int[][] pairs = new int[5][];
                pairs[0] = new int[]{1};
                pairs[1] = new int[]{4};
                pairs[2] = new int[]{3};
                pairs[3] = new int[]{6};
                pairs[4] = new int[]{5,8};
                addNeighbors(neighbors,visited,pairs);
                break;
            }
            case 3: {
                int[][] pairs = new int[3][];
                pairs[0] = new int[]{2,1};
                pairs[1] = new int[]{9,9};
                pairs[2] = new int[]{5,7};
                addNeighbors(neighbors,visited,pairs);
                break;
            }
            case 4: {
                int[][] pairs = new int[5][];
                pairs[0] = new int[]{1};
                pairs[1] = new int[]{2};
                pairs[2] = new int[]{7};
                pairs[3] = new int[]{8};
                pairs[4] = new int[]{5,6};
                addNeighbors(neighbors,visited,pairs);
                break;
            }
            case 5: {
                int[][] pairs = new int[8][];
                pairs[0] = new int[]{1};
                pairs[1] = new int[]{2};
                pairs[2] = new int[]{3};
                pairs[3] = new int[]{6};
                pairs[4] = new int[]{9};
                pairs[5] = new int[]{8};
                pairs[6] = new int[]{7};
                pairs[7] = new int[]{4};
                addNeighbors(neighbors,visited,pairs);
                break;
            }
            case 6: {
                int[][] pairs = new int[5][];
                pairs[0] = new int[]{3};
                pairs[1] = new int[]{2};
                pairs[2] = new int[]{8};
                pairs[3] = new int[]{9};
                pairs[4] = new int[]{5,4};
                addNeighbors(neighbors,visited,pairs);
                break;
            }
            case 7: {
                int[][] pairs = new int[3][];
                pairs[0] = new int[]{4,1};
                pairs[1] = new int[]{5,3};
                pairs[2] = new int[]{8,9};
                addNeighbors(neighbors,visited,pairs);
                break;
            }
            case 8: {
                int[][] pairs = new int[5][];
                pairs[0] = new int[]{7};
                pairs[1] = new int[]{4};
                pairs[2] = new int[]{9};
                pairs[3] = new int[]{6};
                pairs[4] = new int[]{5,2};
                addNeighbors(neighbors,visited,pairs);
                break;
            }
            case 9: {
                int[][] pairs = new int[3][];
                pairs[0] = new int[]{5,1};
                pairs[1] = new int[]{6,3};
                pairs[2] = new int[]{8,7};
                addNeighbors(neighbors,visited,pairs);
                break;
            }
        }

    }

    public void addNeighbors(List<Integer> neighbors, boolean[] visited, int[][] pairs) {
        for (int i = 0; i < pairs.length; i++) {
            if (!visited[pairs[i][0]]) neighbors.add(pairs[i][0]);
            else {
                if (pairs[i].length > 1 && !visited[pairs[i][1]]) neighbors.add(pairs[i][1]);
            }
        }
    }

    public static void main(String[] args) {
        p351 sol = new p351();
        System.out.println(sol.numberOfPatterns(1,1));
    }
}
