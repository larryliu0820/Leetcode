import java.util.*;

/**
 * Created by Larry Liu on 9/27/2017.
 * 269. Alien Dictionary
 */
public class p269 {
    public String alienOrder(String[] words) {
        Map<Character, Set<Character>> map = new HashMap<>();
        if (words.length == 0) return "";
        int maxLen = 0;
        for (String word: words) {
            maxLen = Math.max(maxLen, word.length());
        }
        int j = 0;
        while (j < maxLen) {
            String prefix = "";
            char last = '\0';
            for (int i = 0; i < words.length; i++) {
                String word = words[i];
                if (word.length() <= j) continue;
                if (i == 0 || !word.substring(0, j).equals(prefix)) {
                    prefix = word.substring(0, j);
                    last = word.charAt(j);
                    map.putIfAbsent(last, new HashSet<>());
                } else {
                    char curr = word.charAt(j);
                    map.putIfAbsent(last, new HashSet<>());
                    if (curr != last) {
                        map.get(last).add(curr);
                        last = curr;
                    }
                }
            }
            j++;
        }
        Stack<Character> stack = new Stack<>();
        boolean[][] visited = new boolean[2][128];
        for (char c: map.keySet())
            if (!visited[0][c])
                if (topoSort(visited, stack, map, c)) return "";
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        return sb.toString();
    }

    private boolean topoSort(boolean[][] visited,
                             Stack<Character> stack,
                             Map<Character, Set<Character>> map,
                             char c) {
        if (!visited[0][c]) {
            visited[0][c] = true;
            visited[1][c] = true;
            if (map.containsKey(c)) {
                for (char neighbor : map.get(c)) {
                    if (!visited[0][neighbor]) {
                        boolean ret = topoSort(visited, stack, map, neighbor);
                        if (ret) return true;
                    }
                    if (visited[1][neighbor]) return true;
                }
            }
            stack.push(c);
        }
        visited[1][c] = false;
        return false;
    }

    public static void main(String[] args) {
        p269 sol = new p269();
        sol.alienOrder(new String[]{"ab","adc"});
    }
}
