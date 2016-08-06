import java.util.ArrayList;

/**
 * Created by Valued Customer on 8/4/2016.
 * 74. Search a 2D Matrix
 * Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:

 Integers in each row are sorted from left to right.
 The first integer of each row is greater than the last integer of the previous row.
 For example,

 Consider the following matrix:

 [
 [1,   3,  5,  7],
 [10, 11, 16, 20],
 [23, 30, 34, 50]
 ]
 Given target = 3, return true.
 */
public class p074 {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        if (m == 1 && n == 1) return matrix[0][0] == target;
        int[][] range = new int[2][2];
        range[0][0] = 0;
        range[0][1] = 0;
        range[1][0] = m-1;
        range[1][1] = n-1;

        if (matrix[range[0][0]][range[0][1]] > target) return false;
        if (matrix[range[1][0]][range[1][1]] < target) return false;
        while(n * range[0][0] + range[0][1]  <= n * range[1][0] + range[1][1]) {
            int[] mid = getMid(range, n);
            System.out.println("range = [[" + range[0][0] + ", " + range[0][1] + "], [" + range[1][0] + ", " + range[1][1] + "]]");
            System.out.println("mid = [" + mid[0] + ", " + mid[1] + "]");
            if (matrix[mid[0]][mid[1]] == target) return true;
            else if (matrix[mid[0]][mid[1]] > target) {
                if (mid[1] > 0)
                    mid[1]--;
                else if (mid[0] > 0) {
                    mid[0]--;
                    mid[1] = n-1;
                }
                range[1][0] = mid[0];
                range[1][1] = mid[1];
            } else {
                if (mid[1] < n-1)
                    mid[1]++;
                else if (mid[0] < m-1) {
                    mid[0]++;
                    mid[1] = 0;
                }
                range[0][0] = mid[0];
                range[0][1] = mid[1];
            }
        }
        return false;
    }

    public int[] getMid(int[][] range, int n) {
        int dist = n - 1 - range[0][1] + n * (range[1][0] - range[0][0] - 1) + range[1][1];
        System.out.println("dist = " + dist);
        int mid = dist / 2;
        int[] result = new int[2];
        if (mid < (n - range[0][1])) {
            result[0] = range[0][0];
            result[1] = range[0][1] + mid;
        } else {
            result[0] = range[0][0] + ((mid - n + range[0][1] + 1)/n  + 1);
            result[1] = (mid - n + range[0][1] + 1) % n == 0? (n-1):((mid - n + range[0][1] + 1) % n);
        }
        return result;
    }

    public static void main(String[] args) {
        p074 sol = new p074();
        int[][] matrix = new int[3][];
//        for (int i = 0; i < 2; i++) {
//            for (int j = 0; j < 1; j++) {
//                matrix[i][j] = i*3 + 2 * j;
//            }
//        }
        matrix[0] = new int[]{1,3,5,7};
        matrix[1] = new int[]{10,11,16,20};
        matrix[2] = new int[]{23,30,34,50};
        System.out.println(sol.searchMatrix(matrix, 7));

        int[][] range = new int[2][];
        range[0] = new int[]{1,2};
        range[1] = new int[]{4,5};
        int[] mid = sol.getMid(range, 6);
        System.out.println("mid = [" + mid[0] + ", " + mid[1] + "]");
    }
}
