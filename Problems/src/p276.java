/**
 * Created by larryliu on 8/28/16.
 * 276. Paint Fence
 * There is a fence with n posts, each post can be painted with one of the k colors.

 You have to paint all the posts such that no more than two adjacent fence posts have the same color.

 Return the total number of ways you can paint the fence.

 Note:
 n and k are non-negative integers.
 */
public class p276 {

    public int numWays(int n, int k){
        if (k == 0) return 0;
        if (n == 0) return 0;
        int ways_i1 = k, ways_i2 = 0;

        for (int i = 2; i <= n; i++) {
            int temp = ways_i1;
            ways_i1 = ways_i1 * (k-1) + ways_i2 * (k-1);
            ways_i2 = temp;

        }
        return ways_i1 + ways_i2;
    }
}
