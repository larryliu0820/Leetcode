import java.util.Arrays;

/**
 * Created by Valued Customer on 8/10/2017.
 * 452. Minimum Number of Arrows to Burst Balloons
 */
public class p452 {
    public int findMinArrowShots(int[][] points) {
        if (points == null || points.length == 0) return 0;
        Arrays.sort(points, (a, b)->a[1]-b[1]);
        int count = 1, arrow = points[0][1];
        for (int[] p : points) {
            if (arrow >= p[0]) continue;
            arrow = p[1];
            count++;
        }
        return count;
    }
}
