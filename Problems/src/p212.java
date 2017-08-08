import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/**
 * Created by Valued Customer on 7/27/2017.
 * 212. Word Search II
 */
public class p212 {
    class TrieNode {
        boolean isWord;
        TrieNode[] neighbors;
        TrieNode() {
            neighbors = new TrieNode[26];
        }
    }

    char[][] board;
    TrieNode head;
    boolean[][] visited;
    public List<String> findWords(char[][] board, String[] words) {
        this.board = board;
        head = new TrieNode();

        for (String word: words) {
            TrieNode itr = head;
            for (char c : word.toCharArray()) {
                if (itr.neighbors[c-'a'] == null) itr.neighbors[c-'a'] = new TrieNode();
                itr = itr.neighbors[c-'a'];
            }
            itr.isWord = true;
        }

        int m = board.length, n = board[0].length;
        Set<String> result = new HashSet<>();
        visited = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                dfs(i, j, head, "", result);
            }
        }
        return new LinkedList<>(result);
    }

    private void dfs(int i, int j, TrieNode node, String curr, Set<String> result) {
        if (node.neighbors[board[i][j]-'a'] == null || visited[i][j]) return;
        TrieNode currNode = node.neighbors[board[i][j]-'a'];
        visited[i][j] = true;
        curr += board[i][j];
        if (currNode.isWord)
            result.add(curr);
        if (i > 0)
            dfs(i-1, j, currNode, curr, result);
        if (i < board.length-1)
            dfs(i+1, j, currNode, curr, result);
        if (j > 0)
            dfs(i, j-1, currNode, curr, result);
        if (j < board[0].length-1)
            dfs(i, j+1, currNode, curr, result);
        visited[i][j] = false;
    }

    public static void main(String[] args) {
        p212 sol = new p212();
        char[][] board = new char[][]{{'a', 'a'}};
        sol.findWords(board, new String[]{"aaa"});
    }
}
