/**
 * Created by Valued Customer on 7/6/2017.
 *
 * 566. Reshape the Matrix
 *
 *
 */
public class p566 {
    public int[][] matrixReshape(int[][] nums, int r, int c) {
        if (nums == null || nums[0] == null) return null;
        int m = nums.length;
        int n = nums[0].length;
        if (r * c != m * n) return nums;
        int[][] result = new int[r][c];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int row = (i * n + j) / c;
                int col = (i * n + j) % c;
                result[row][col] = nums[i][j];
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[][] nums = new int[2][];
        nums[0] = new int[]{1,2};
        nums[1] = new int[]{3,4};
        p566 sol = new p566();
        sol.matrixReshape(nums, 1, 4);
    }
}
