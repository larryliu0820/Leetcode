import java.util.ArrayList;
import java.util.List;

/**
 * Created by mengwliu on 8/5/16.
 * 79. Word Search
 *  Given a 2D board and a word, find if the word exists in the grid.

 The word can be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those horizontally or vertically neighboring. The same letter cell may not be used more than once.

 For example,
 Given board =

 [
 ['A','B','C','E'],
 ['S','F','C','S'],
 ['A','D','E','E']
 ]

 word = "ABCCED", -> returns true,
 word = "SEE", -> returns true,
 word = "ABCB", -> returns false.
 */
public class p079 {
    class TrieNode {
        TrieNode[] neighbors;
        boolean isWord;
        TrieNode() {
            neighbors = new TrieNode[256];
            isWord = false;
        }
    }
    boolean[][] visited;
    char[][] board;
    public boolean exist(char[][] board, String word) {
        TrieNode root = new TrieNode();
        TrieNode itr = root;
        for (char c: word.toCharArray()) {
            itr.neighbors[c] = new TrieNode();
            itr = itr.neighbors[c];
        }
        itr.isWord = true;
        this.board = board;
        int m = board.length, n = board[0].length;
        visited = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (dfs(i, j, root)) return true;
            }
        }
        return false;
    }

    private boolean dfs(int i, int j, TrieNode node) {
        if (!isValid(i,j) || visited[i][j]) return false;
        if (node.neighbors[board[i][j]] == null) return false;
        else if (node.neighbors[board[i][j]].isWord) return true;
        visited[i][j] = true;
        TrieNode nextNode = node.neighbors[board[i][j]];
        if (dfs(i+1, j, nextNode)) return true;
        if (dfs(i-1, j, nextNode)) return true;
        if (dfs(i, j+1, nextNode)) return true;
        if (dfs(i, j-1, nextNode)) return true;
        visited[i][j] = false;
        return false;
    }

    private boolean isValid(int i, int j) {
        int m = board.length, n = board[0].length;
        return (i < m && i >= 0 && j < n && j >= 0);
    }
    public static void main(String[] args) {
        p079 sol = new p079();
        char[][] board = new char[3][];
        board[0] = new char[]{'A','B','C','E'};
        board[1] = new char[]{'S','F','E','S'};
        board[2] = new char[]{'A','D','E','E'};

        System.out.println(sol.exist(board, "ABCESEEEFS"));
    }
}
