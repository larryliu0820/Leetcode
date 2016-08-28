/**
 * Created by Valued Customer on 8/26/2016.
 * 240. Search a 2D Matrix II
 * Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:

 Integers in each row are sorted in ascending from left to right.
 Integers in each column are sorted in ascending from top to bottom.
 For example,

 Consider the following matrix:

 [
 [1,   4,  7, 11, 15],
 [2,   5,  8, 12, 19],
 [3,   6,  9, 16, 22],
 [10, 13, 14, 17, 24],
 [18, 21, 23, 26, 30]
 ]
 Given target = 5, return true.

 Given target = 20, return false.
 */
public class p240 {
    public boolean searchMatrix(int[][] matrix, int target) {
        // binary search
        if (matrix == null || matrix.length == 0) return false;
        int rows = matrix.length;
        int cols = matrix[0].length;

        int numShells = Math.min(rows, cols);

        int endShell = numShells - 1;
        int beginShell = 0;

        return true;

    }
}
