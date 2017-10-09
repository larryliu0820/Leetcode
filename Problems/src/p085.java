import java.util.Stack;

/**
 * Created by mengwliu on 9/6/17
 * 85. Maximal Rectangle
 *
 * Given a 2D binary matrix filled with 0's and 1's, find the largest rectangle containing only 1's and return its area.

 For example, given the following matrix:

 1 0 1 0 0
 1 0 1 1 1
 1 1 1 1 1
 1 0 0 1 0
 Return 6.
 */
/*
    1 0 1 0 0
    2 0 2 1 1
    3 1 3 2 2
    4 0 0 3 0
 */
public class p085 {
    public int maximalRectangle(char[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return 0;
        int m = matrix.length;
        int n = matrix[0].length;
        int[] height = new int[n+1];
        int max = 0;

        for (int row = 0; row < m; row++) {
            Stack<Integer> stack = new Stack<>();
            for (int col = 0; col <= n; col++) {
                if (col < n) {
                    if (matrix[row][col] == '1')
                        height[col] += 1;
                    else
                        height[col] = 0;
                }
                while (!stack.isEmpty() && height[col] < height[stack.peek()]) {
                    int top = stack.pop();
                    int area = height[top] * (stack.isEmpty() ? col : (col - stack.peek() - 1));
                    max = Math.max(max, area);
                }

                stack.push(col);
            }
        }
        return max;

    }
}
