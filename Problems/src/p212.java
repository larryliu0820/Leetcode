import java.util.*;

/**
 * Created by Valued Customer on 7/27/2017.
 * 212. Word Search II
 */
public class p212 {
    class TrieNode {
        // Initialize your data structure here.
        TrieNode[] next = new TrieNode[26];
        String word;
    }

    char[][] board;
    Set<String> result;
    boolean[][] visited;
    int[][] inc = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public List<String> findWords(char[][] board, String[] words) {
        this.board = board;
        TrieNode root = new TrieNode();
        for (String w: words) {
            TrieNode p = root;
            for (char c : w.toCharArray()) {
                if (p.next[c-'a'] == null) p.next[c - 'a'] = new TrieNode();
                p = p.next[c - 'a'];
            }
            p.word = w;
        }
        result = new HashSet<>();
        int m = board.length, n = board[0].length;
        visited = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                search2(i, j, root);
            }
        }
        return new LinkedList<>(result);
    }


    private void search2(int i, int j, TrieNode node) {
        int m = board.length, n = board[0].length;
        if (node.next[board[i][j]-'a'] == null) return;
        node = node.next[board[i][j]-'a'];
        visited[i][j] = true;
        if (node.word != null) result.add(node.word);
        for (int[] d: inc) {
            if (isValid(m, n, i+d[0], j+d[1]) &&
                    !visited[i+d[0]][j+d[1]])
                search2(i+d[0], j+d[1], node);
        }
        visited[i][j] = false;
    }

    private boolean isValid(int m , int n, int i, int j) {
        return !(i < 0 || i >= m || j < 0 || j >= n);
    }
}
