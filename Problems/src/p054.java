import java.util.ArrayList;
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
        int height = matrix.length;
        List<Integer> result = new ArrayList<>();
        if (height == 0) return result;
        int width = matrix[0].length;
        int depth = 0;
        while(depth < (height + 1) / 2 && depth < (width + 1) / 2) {
            // left to right
            for (int i = depth; i < width - depth; i++) {
                result.add(matrix[depth][i]);
            }

            // up to down
            for (int i = depth + 1; i < height - depth; i++) {
                result.add(matrix[i][width - depth - 1]);
            }

            if (height / 2 != depth) {
                // right to left
                for (int i = width - depth - 2; i >= depth; i--) {
                    result.add(matrix[height - depth - 1][i]);
                }
            }

            if (width / 2 != depth) {
                // down to up
                for (int i = height - depth - 2; i >= depth + 1; i--) {
                    result.add(matrix[i][depth]);
                }
            }

            depth++;
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
