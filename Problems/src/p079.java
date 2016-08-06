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
    public boolean exist(char[][] board, String word) {
        char[] wordArray = word.toCharArray();
        if (board == null || board[0].length == 0) return false;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                System.out.println("i = " + i + ", j = " + j);
                if (word.charAt(0) != board[i][j]) continue;
                if(dfs(board, new boolean[board.length][board[0].length], new int[]{i,j}, wordArray, 0)) return true;
            }
        }
        return false;
    }

    public boolean dfs(char[][] board, boolean[][] visited, int[] pos, char[] word, int index) {
        if (visited[pos[0]][pos[1]]) return false;
        if (word[index] != board[pos[0]][pos[1]]) return false;

        visited[pos[0]][pos[1]] = true;
        if (index == word.length - 1) return true;
        // up
        if (pos[0] > 0) {
            pos[0]--;
            if (dfs(board, visited, pos, word, index+1)) return true;
            pos[0]++;
        }

        // left
        if (pos[1] > 0) {
            pos[1]--;
            if (dfs(board, visited, pos, word, index+1)) return true;
            pos[1]++;
        }

        // down
        if (pos[0] < board.length - 1) {
            pos[0]++;
            if (dfs(board, visited, pos, word, index+1)) return true;
            pos[0]--;
        }

        // right
        if (pos[1] < board[0].length - 1) {
            pos[1]++;
            if (dfs(board, visited, pos, word, index+1)) return true;
            pos[1]--;
        }

        visited[pos[0]][pos[1]] = false;
        return false;
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
