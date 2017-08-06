import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by mengwliu on 7/29/16.
 * 54. Spiral Matrix
 * Given a matrix of m x n elements (m rows, n columns), return all elements of the matrix in spiral order.

 For example,
 Given the following matrix:

 [
 [ 1, 2, 3 ],
 [ 4, 5, 6 ],
 [ 7, 8, 9 ]
 ]

 You should return [1,2,3,6,9,8,7,4,5].
 */
public class p054 {

    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new LinkedList<>();
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return result;
        int m = matrix.length, n = matrix[0].length;
        int smaller = m < n ? m:n;
        int step = 0;
        for (; step < smaller/2; step++) {
            // left to right;
            for (int i = step; i < n - step - 1; i++) result.add(matrix[step][i]);
            // up to down
            for (int i = step; i < m - step - 1; i++) result.add(matrix[i][n-step-1]);
            // right to left
            for (int i = n - step - 1; i > step; i--) result.add(matrix[m-step-1][i]);
            // down to up
            for (int i = m - step - 1; i > step; i--) result.add(matrix[i][step]);
        }
        if (smaller % 2 == 1) {
            if (m > n) {
                for (int i = step; i < m - step; i++) result.add(matrix[i][n-step-1]);
            } else {
                for (int i = step; i < n - step; i++) result.add(matrix[m-step-1][i]);
            }
        }
        return result;
    }
    public static void main(String[] args) {
        p054 sol = new p054();
        int[][] matrix = {
                {1,2,3},
                {4,5,6}
        };
        List<Integer> result = sol.spiralOrder(matrix);
        System.out.print("result = [");
        for (int i : result) {
            System.out.print(i + ", ");
        }
        System.out.print("]");
    }
}
