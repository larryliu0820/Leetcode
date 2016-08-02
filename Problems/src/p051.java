import java.util.ArrayList;
import java.util.List;

/**
 * Created by Valued Customer on 8/1/2016.
 * 51. N-Queens
 * The n-queens puzzle is the problem of placing n queens on an n×n chessboard such that no two queens attack each other.



 Given an integer n, return all distinct solutions to the n-queens puzzle.

 Each solution contains a distinct board configuration of the n-queens' placement, where 'Q' and '.' both indicate a queen and an empty space respectively.

 For example,
 There exist two distinct solutions to the 4-queens puzzle:

 [
 [".Q..",  // Solution 1
 "...Q",
 "Q...",
 "..Q."],

 ["..Q.",  // Solution 2
 "Q...",
 "...Q",
 ".Q.."]
 ]
 */
public class p051 {
    public List<List<String>> solveNQueens(int n) {
        boolean[][] hasQueen = new boolean[3][2*n-1];
        List<Integer> list = new ArrayList<>();
        List<List<String>> set = new ArrayList<>();
        dfsHelper(list, hasQueen, set);
        return set;
    }

    public void dfsHelper(List<Integer> list, boolean[][] hasQueen, List<List<String>> set) {
        int length = (hasQueen[0].length + 1) / 2;
        if (list.size() == length) {
            List<String> sol = new ArrayList<>();
            for (int i = 0; i < length; i++) {
                String s = "";
                for (int j = 0; j < list.get(i); j++) s += ".";
                s += "Q";
                for (int j = list.get(i) + 1; j < length; j++) s += ".";
                System.out.println(s);
                sol.add(s);
            }
            set.add(sol);
        } else if (list.size() < length){
            for (int i = 0; i < length; i++) {
                int ind = list.size();
                if (hasQueen[0][i - ind + length - 1]) continue;
                if (hasQueen[1][i + ind]) continue;
                if (hasQueen[2][i]) continue;

                list.add(i);
                hasQueen[0][i - ind + length - 1] = true;
                hasQueen[1][i + ind] = true;
                hasQueen[2][i] = true;

                dfsHelper(list, hasQueen, set);

                hasQueen[2][i] = false;
                hasQueen[1][i + ind] = false;
                hasQueen[0][i - ind + length - 1] = false;
                list.remove(list.size()-1);
            }
        }
    }
    public static void main(String[] args) {
        p051 sol = new p051();
        List<List<String>> result = sol.solveNQueens(4);
        System.out.println("[");
        for (List<String> list : result) {
            System.out.print("[");
            for (String s : list) System.out.print(s+",\n");
            System.out.print("]\n");
        }
        System.out.println("]");
    }
}
