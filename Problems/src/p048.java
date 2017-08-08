/**
 * Created by larryliu on 8/2/17.
 * 48. Rotate Image
 */
public class p048 {
    public void rotate(int[][] matrix) {
        int depth = matrix.length / 2;
        for (int d = 0; d < depth; d++) {
            for (int i = d; i < matrix.length - d - 1; i++) rotateHelper(matrix, new int[]{d, i});
        }
    }

    private void rotateHelper(int[][] matrix, int[] upperLeft) {
        int[] upperRight = new int[]{upperLeft[1], matrix.length - 1 - upperLeft[0]};
        int[] lowerRight = new int[]{matrix.length - 1 - upperLeft[0], matrix.length - 1 - upperLeft[1]};
        int[] lowerLeft = new int[]{matrix.length - 1 - upperLeft[1], upperLeft[0]};

        int temp = matrix[upperLeft[0]][upperLeft[1]];
        matrix[upperLeft[0]][upperLeft[1]] = matrix[lowerLeft[0]][lowerLeft[1]];
        matrix[lowerLeft[0]][lowerLeft[1]] = matrix[lowerRight[0]][lowerRight[1]];
        matrix[lowerRight[0]][lowerRight[1]] = matrix[upperRight[0]][upperRight[1]];
        matrix[upperRight[0]][upperRight[1]] = temp;
    }
}
