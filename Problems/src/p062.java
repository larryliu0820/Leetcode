/**
 * Created by Valued Customer on 8/3/2016.
 * 62. Unique Paths
 * A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).

 The robot can only move either down or right at any point in time. The robot is trying to reach the bottom-right corner of the grid (marked 'Finish' in the diagram below).

 How many possible unique paths are there?
 Note: m and n will be at most 100.
 */
public class p062 {
    public int uniquePaths(int m, int n) {
        int[] result = new int[n];
        for (int i = 0; i < n; i ++) result[i] = 1;
        for (int i = 1; i < m; i ++) {
            for (int j = 1; j < n; j++) {
                result[j] = result[j] + result[j-1];
            }
        }
        return result[n-1];
    }
    public static void main(String[] args) {
        p062 sol = new p062();
        System.out.println("result = " + sol.uniquePaths(1, 2));
    }
}
