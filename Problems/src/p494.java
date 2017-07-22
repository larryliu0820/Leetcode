/**
 * Created by Valued Customer on 7/14/2017.
 * 494. Target Sum
 */
public class p494 {
    public int findTargetSumWays(int[] nums, int S) {
        int count = dfs(nums, 0, 0, S, true);
        count += dfs(nums, 0, 0, S, false);
        return count;
    }

    private int dfs(int[] nums, int index, int currSum, int target, boolean isAdd) {
        if (index == nums.length-1) {
            if (isAdd) return currSum + nums[index] == target? 1: 0;
            else return currSum - nums[index] == target? 1: 0;
        }
        int newSum = isAdd?currSum+nums[index]:currSum-nums[index];
        int count = dfs(nums, index+1, newSum, target, false);
        count += dfs(nums, index+1, newSum, target, true);

        return count;
    }
}
