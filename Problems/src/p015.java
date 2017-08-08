import java.util.*;

/**
 * Created by larryliu on 9/18/16.
 * 15. 3Sum
 * Given an array S of n integers, are there elements a, b, c in S such that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.

 Note: The solution set must not contain duplicate triplets.

 For example, given array S = [-1, 0, 1, 2, -1, -4],

 A solution set is:
 [
 [-1, 0, 1],
 [-1, -1, 2]
 ]
 */
public class p015 {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new LinkedList<>();
        if (nums == null || nums.length < 3) return result;
        Arrays.sort(nums);

        for (int i = 0; i < nums.length-2; i++) {
            if (i > 0 && nums[i] == nums[i-1]) continue;
            int lo = i+1, hi = nums.length - 1;
            int target = -nums[i];
            while (lo < hi) {
                if (lo != i+1 && nums[lo] == nums[lo-1]) {
                    lo++;
                    continue;
                }
                if (hi != nums.length - 1 && nums[hi] == nums[hi+1]) {
                    hi--;
                    continue;
                }
                if (nums[lo] + nums[hi] > target) hi--;
                else if (nums[lo] + nums[hi] < target) lo++;
                else {
                    List<Integer> ans = new LinkedList<>();
                    ans.add(nums[i]);
                    ans.add(nums[lo++]);
                    ans.add(nums[hi--]);
                    result.add(ans);
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{-2, 0, 0, 2, 2};
        p015 sol = new p015();
        sol.threeSum(nums);
    }
}
