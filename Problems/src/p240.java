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

        return searchMatrixHelper(matrix, 0, 0, matrix.length - 1, matrix[0].length - 1, target);

    }





    public boolean searchMatrixHelper(int[][] matrix, int beginRow, int beginCol, int endRow, int endCol, int target) {
        if (beginRow >= matrix.length || beginCol >= matrix[0].length) return false;

        if (beginCol == endCol) return searchACol(matrix, beginCol, beginRow, endRow, target);
        if (beginRow == endRow) return searchARow(matrix[beginRow], beginCol, endCol, target);
        int min = matrix[beginRow][beginCol];
        int max = matrix[endRow][endCol];

        if (target < min || target > max) return false;
        if (target == min || target == max) return true;
        int itrNum = 0;
        while (beginRow + itrNum < matrix.length &&
                beginCol + itrNum < matrix[0].length &&
                matrix[beginRow + itrNum][beginCol + itrNum] < target)
            itrNum ++;

        if (beginRow+itrNum < matrix.length &&
                beginCol + itrNum < matrix[0].length &&
                matrix[beginRow+itrNum][beginCol+itrNum] == target)
            return true;

        if(searchMatrixHelper(matrix, beginRow + itrNum, beginCol, endRow, beginCol + itrNum - 1, target))
            return true;
        return searchMatrixHelper(matrix, beginRow, beginCol + itrNum, beginRow + itrNum - 1, endCol, target);
    }

    public boolean searchARow(int[] row, int begin, int end, int target) {
        while (begin <= end) {
            if (target == row[begin] || target == row[end]) return true;
            int mid = (begin + end) / 2;
            if (target == row[mid]) return true;
            if (target < row[mid]) {
                end = mid - 1;
            } else {
                begin = mid + 1;
            }
        }
        return false;
    }

    public boolean searchACol(int[][] matrix, int colInd, int begin, int end, int target) {
        while (begin <= end) {
            if (target == matrix[begin][colInd] || target == matrix[end][colInd]) return true;
            int mid = (begin + end) / 2;
            if (target == matrix[mid][colInd]) return true;
            if (target < matrix[mid][colInd]) {
                end = mid - 1;
            } else {
                begin = mid + 1;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        p240 sol = new p240();
        int[][] m = new int[2][];
        m[0] = new int[]{1,   2,  3,  4,  5};
        m[1] = new int[]{6,   7,  8,  9, 10};
//        m[2] = new int[]{11, 12, 13, 14, 15};
//        m[3] = new int[]{16, 17, 18, 19, 20};
//        m[4] = new int[]{21, 22, 23, 24, 25};

        System.out.print(sol.searchMatrix(m, 4));
    }
}
