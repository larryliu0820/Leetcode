import java.util.Arrays;

/**
 * Created by Valued Customer on 8/17/2016.
 * 259. 3Sum Smaller
 * Given an array of n integers nums and a target, find the number of index triplets i, j, k with 0 <= i < j < k < n that
 * satisfy the condition nums[i] + nums[j] + nums[k] < target.

 For example, given nums = [-2, 0, 1, 3], and target = 2.

 Return 2. Because there are two triplets which sums are less than 2:

 [-2, 0, 1]
 [-2, 0, 3]
 Follow up:
 Could you solve it in O(n2) runtime?
 */
public class p259 {
    public int threeSumSmaller(int[] nums, int target) {
        if (nums == null || nums.length < 3) return 0;
        Arrays.sort(nums);
        int count = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            int max = target - nums[i];
            int j = i + 1, k = nums.length - 1;
            if (2 * nums[j] > max) return count;
            while (j < k) {
                if (nums[j] + nums[k] >= max) {
                    k--;
                } else {
                    count += (k-j);
                    j++;
                    k = nums.length - 1;
                }
            }
        }
        return count;
    }
}
