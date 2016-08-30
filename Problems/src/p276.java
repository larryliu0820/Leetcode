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
        if (n <= 1 || k <= 0) return n*k;
        if (k == 1) return n > 2 ? 0 : 1;

        int[] ways = new int[n];
        ways[0] = k;
        ways[1] = k*k;
        for(int i=2; i < n; i++){
            ways[i] = (k-1)*ways[i-1] + (k-1)*ways[i-2];
        }

        return ways[n-1];
    }
}
