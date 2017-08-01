import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * Created by Valued Customer on 7/30/2017.
 * 631. Design Excel Sum Formula
 */
public class p631 {
    class Formula {
        Map<String, Integer> cells;
        int val;
        Formula(Map<String, Integer> c, int v) {
            val = v;
            cells = c;
        }
    }
    Formula[][] table;
    Stack<int[]> stack = new Stack<>();
    public p631(int H, char W) {
        table = new Formula[H][W-'A'+1];
    }

    public void set(int r, char c, int v) {
        table[r-1][c-'A'] = new Formula(new HashMap<>(), v);
        topologicalSort(r-1, c-'A');
        executeStack();
    }

    public int get(int r, char c) {
        return table[r-1][c-'A'] == null?0:table[r-1][c-'A'].val;
    }

    public int sum(int r, char c, String[] strs) {
        Map<String, Integer> cells = convert(strs);
        int sumStrs = calculateSum(r-1, c-'A', cells);
        set(r, c, sumStrs);
        table[r-1][c-'A'] = new Formula(cells, sumStrs);
        return sumStrs;
    }

    private void topologicalSort(int r, int c) {
        for (int i = 0; i < table.length; i++)
            for (int j = 0; j < table[0].length; j++)
                if (table[i][j] != null && table[i][j].cells.containsKey("" + (char)('A' + c) + (r + 1))) {
                    topologicalSort(i, j);
                }
        stack.push(new int[] {r, c});
    }

    private Map<String, Integer> convert(String[] strs) {
        Map<String, Integer> res = new HashMap<>();
        for (String s: strs) {
            if (!s.contains(":")) res.put(s, res.getOrDefault(s, 0) + 1);
            else {
                String[] cells = s.split(":");
                int si = Integer.parseInt(cells[0].substring(1));
                int ei = Integer.parseInt(cells[1].substring(1));
                char sj = cells[0].charAt(0), ej = cells[1].charAt(0);
                for (int i = si; i <= ei; i++) {
                    for (char j = sj; j<= ej; j++) {
                        res.put("" + j + i, res.getOrDefault("" + j + i, 0) + 1);
                    }
                }
            }
        }
        return res;
    }

    private int calculateSum(int r, int c, Map<String, Integer> cells) {
        int sum = 0;
        for (String s: cells.keySet()) {
            int x = Integer.parseInt(s.substring(1))-1, y = s.charAt(0)-'A';
            sum += (table[x][y] != null ? table[x][y].val:0) * cells.get(s);
        }
        table[r][c] = new Formula(cells, sum);
        return sum;
    }

    private void executeStack() {
        while (!stack.isEmpty()) {
            int[] top = stack.pop();
            if (table[top[0]][top[1]].cells.size()>0)
                calculateSum(top[0], top[1], table[top[0]][top[1]].cells);
        }
    }
}
