import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by mengwliu on 7/27/16.
 * 16. 3Sum Closest
 * Given an array S of n integers, find three integers in S such that the sum is closest to a given number, target.
 * Return the sum of the three integers. You may assume that each input would have exactly one solution.

 For example, given array S = {-1 2 1 -4}, and target = 1.

 The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).

 */
public class p016 {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int closestSum = target > 0? Integer.MIN_VALUE + 1 + target: Integer.MAX_VALUE - target;
        for (int i = 0; i < nums.length - 2; i++) {
            int first = nums[i];
            System.out.println("first = " + first);
            int sum = twoSumClosest(nums, target - first, i+1) + first;
            System.out.println("threeSum = " + sum);
            if (Math.abs(closestSum - target) > Math.abs(sum - target)) closestSum = sum;
            System.out.println("closestSum = " + closestSum);
        }
        return closestSum;
    }

    public int twoSumClosest(int[] nums, int target, int startInd) {
        int closestSum = nums[startInd] + nums[nums.length - 1];
        if (closestSum == target) return target;
        int i = startInd, j = nums.length - 1;
        while (i < j) {
            System.out.print("i = " + i + " j = " + j);
            int sum = nums[i] + nums[j];
            System.out.print(" sum = " + sum);
            if (sum < target) i++;
            else if (sum > target) j--;
            else return target;
            if(Math.abs(sum - target) < Math.abs(closestSum - target)) {
                closestSum = sum;
            }
        }
        return closestSum;
    }

    public static void main(String[] args) {
        p016 sol = new p016();
        int[] nums = new int[]{0,0,0};
        int result = sol.threeSumClosest(nums, 1);
        System.out.println("result = " + result);
    }
}
