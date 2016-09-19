import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by larryliu on 9/18/16.
 * 1. Two Sum
 * Given an array of integers, return indices of the two numbers such that they add up to a specific target.

 You may assume that each input would have exactly one solution.

 Example:
 Given nums = [2, 7, 11, 15], target = 9,

 Because nums[0] + nums[1] = 2 + 7 = 9,
 return [0, 1].
 UPDATE (2016/2/13):
 The return format had been changed to zero-based indices. Please read the above updated description carefully.


 */
public class p001 {
    public int[] twoSum(int[] nums, int target) {
        if (nums == null || nums.length == 0) return null;
        Num[] objNums = new Num[nums.length];
        for (int i = 0; i < nums.length; i++) {
            objNums[i] = new Num(nums[i], i);
        }
        Arrays.sort(objNums);
        int begin = 0, end = nums.length-1;
        while (begin < end) {
            int currSum = objNums[begin].val + objNums[end].val;
            if (currSum == target) {
                return new int[]{objNums[begin].ind, objNums[end].ind};
            } else if (currSum < target) begin++;
            else end--;
        }
        return null;
    }

    private class Num implements Comparable<Num> {
        int val;
        int ind;
        public Num(int val, int ind) {
            this.val = val;
            this.ind = ind;
        }

        @Override
        public int compareTo(Num n) {
            return this.val - n.val;
        }
    }
}
