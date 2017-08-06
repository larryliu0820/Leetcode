/**
 * Created by Valued Customer on 7/29/2017.
 * 213. House Robber II
 */
public class p213 {
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];
        if (nums.length == 2) return nums[0]>nums[1]?nums[0]:nums[1];
        int m = nums.length;
        int[] dp = new int[m*2];
        dp[0] = nums[0];
        dp[1] = nums[1] > nums[0]?nums[1]:nums[0];
        for (int i = 2; i < dp.length; i++) {
            dp[i] = Math.max(dp[i-1], dp[i-2] + nums[i%m]);
        }
        return dp[m*2-1] - dp[m-1];
    }
}
