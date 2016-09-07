import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

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
    int count = 0;
    public int numberOfPatterns(int m, int n) {
        Set<Integer> current = new HashSet<>();
        helper(current, 0, m, n);
        return count;
    }

    private void helper( Set<Integer> current, int i, int m, int n) {
        if (current.size() > n) return;
        if (current.size() >= m && current.size() <= n) {
            count++;
        }
        if (current.size() == 0) {
            for (int j = 1; j <= 9; j++) {
                current.add(j);
                helper(current, j, m, n);
                current.remove(j);
            }
            return;
        }
        List<Integer> neighbors = new LinkedList<>();
        getNeighbors(neighbors, current, i);
        for (int k : neighbors) {
            current.add(k);
            helper(current, k, m, n);
            current.remove(k);
        }
    }

    private void getNeighbors(List<Integer> neighbors, Set<Integer> current, int last) {
        int[][] pairs;
        switch (last) {
            case 1: {
                pairs = new int[3][];
                pairs[0] = new int[]{2,3};
                pairs[1] = new int[]{5,9};
                pairs[2] = new int[]{4,7};
                if (!current.contains(6)) neighbors.add(6);
                if (!current.contains(8)) neighbors.add(8);
                break;
            }
            case 2:
            case 8: {
                pairs = new int[1][];
                for (int i = 0; i < 3; i++) if (!current.contains(i*3+1)) neighbors.add(i*3+1);
                for (int i = 3; i < 6; i++) if (!current.contains(i*3-6)) neighbors.add(i*3-6);
                if (last == 2)
                    pairs[0] = new int[]{5,8};
                else
                    pairs[0] = new int[]{5,2};
                break;
            }
            case 3: {
                pairs = new int[3][];
                pairs[0] = new int[]{2,1};
                pairs[1] = new int[]{6,9};
                pairs[2] = new int[]{5,7};
                if (!current.contains(4)) neighbors.add(4);
                if (!current.contains(8)) neighbors.add(8);
                break;
            }
            case 4:
            case 6: {
                pairs = new int[1][];
                for (int i = 0; i < 3; i++) if (!current.contains(i+1)) neighbors.add(i+1);
                for (int i = 3; i < 6; i++) if (!current.contains(i+4)) neighbors.add(i+4);
                if (last == 4)
                    pairs[0] = new int[]{5,6};
                else
                    pairs[0] = new int[]{5,4};
                break;
            }
            case 5: {
                for (int i = 0; i < 4; i++) if (!current.contains(i+1)) neighbors.add(i+1);
                for (int i = 4; i < 8; i++) if (!current.contains(i+2)) neighbors.add(i+2);
                return;
            }
            case 7: {
                pairs = new int[3][];
                pairs[0] = new int[]{4,1};
                pairs[1] = new int[]{5,3};
                pairs[2] = new int[]{8,9};
                if (!current.contains(2)) neighbors.add(2);
                if (!current.contains(6)) neighbors.add(6);
                break;
            }
            default: {
                pairs = new int[3][];
                pairs[0] = new int[]{5,1};
                pairs[1] = new int[]{6,3};
                pairs[2] = new int[]{8,7};
                if (!current.contains(4)) neighbors.add(4);
                if (!current.contains(2)) neighbors.add(2);
                break;
            }

        }
        for (int i = 0; i < pairs.length; i++) {
            if (!current.contains(pairs[i][0])) neighbors.add(pairs[i][0]);
            else {
                if (!current.contains(pairs[i][1])) neighbors.add(pairs[i][1]);
            }
        }
    }


    public static void main(String[] args) {
        p351 sol = new p351();
        System.out.println(sol.numberOfPatterns(1,2));
    }
}
