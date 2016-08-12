import javax.print.attribute.IntegerSyntax;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by mengwliu on 8/11/16.
 * 120. Triangle
 * Given a triangle, find the minimum path sum from top to bottom. Each step you may move to adjacent numbers on the row below.

 For example, given the following triangle

 [
 [2],
 [3,4],
 [6,5,7],
 [4,1,8,3]
 ]

 The minimum path sum from top to bottom is 11 (i.e., 2 + 3 + 5 + 1 = 11).

 Note:
 Bonus point if you are able to do this using only O(n) extra space, where n is the total number of rows in the triangle.
 */
public class p120 {
    public int minimumTotal(List<List<Integer>> triangle) {
        int[][] memo = new int[2][triangle.size()];
        if (triangle.size() == 0) return 0;
        memo[0][0] = triangle.get(0).get(0);
        int curr = 0, next = 1;
        for (int i = 1; i < triangle.size(); i++) {
            List<Integer> line = triangle.get(i);
            for (int j = 0; j <= i; j++) {
                int minSum = Integer.MAX_VALUE;
                int num = line.get(j);
                if (j > 0)
                    minSum = minSum>(memo[curr][j-1]+num)?(memo[curr][j-1]+num):minSum;
                if (j != i)
                    minSum = minSum>(memo[curr][j]+num)?(memo[curr][j]+line.get(j)):minSum;
                if (j < i-1)
                    minSum = minSum>(memo[curr][j+1]+line.get(j))?(memo[curr][j+1]+line.get(j)):minSum;
                memo[next][j] = minSum;
                next = (next + 1) % 2;
                curr = (curr + 1) % 2;
            }
        }

        int min = memo[next][0];
        for (int i = 1; i < memo[0].length; i++) {
            min = min < memo[next][i]?min:memo[next][i];
        }

        return min;
    }
}
