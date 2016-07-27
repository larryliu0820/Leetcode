import java.util.HashMap;

/**
 * Created by Valued Customer on 7/25/2016.
 * 377. Combination Sum IV
 * Given an integer array with all positive numbers and no duplicates, find the number of possible combinations that add up to a positive integer target.

 Example:

 nums = [1, 2, 3]
 target = 4

 The possible combination ways are:
 (1, 1, 1, 1)
 (1, 1, 2)
 (1, 2, 1)
 (1, 3)
 (2, 1, 1)
 (2, 2)
 (3, 1)

 Note that different sequences are counted as different combinations.

 Therefore the output is 7.
 Follow up:
 What if negative numbers are allowed in the given array?
 How does it change the problem?
 What limitation we need to add to the question to allow negative numbers?
 */
public class p377 {
    public int combinationSum4(int[] nums, int target) {

        HashMap<Integer, Integer> memo = new HashMap<>();
        combinationSumHelper(nums, target, memo);
        return memo.get(target);
    }

    public void combinationSumHelper(int[] nums, int target, HashMap<Integer, Integer> memo) {
        //System.out.println("target = " + target);
        int sum = 0;
        for (int num : nums) {
            //System.out.println("num = " + num);
            if (!memo.containsKey(target - num)) {
                if (num == target) memo.put(target - num, 1);
                else if (num < target) {
                    combinationSumHelper(nums, target - num, memo);
                } else continue;
            }
            sum += memo.get(target - num);
        }
        //System.out.println("sum = " + sum);

        memo.put(target, sum);
    }

    public static void main(String[] args) {
        p377 sol = new p377();
        int[] nums = new int[]{1,2,3};

        int result = sol.combinationSum4(nums, 4);
        System.out.println("result = " + result);
    }
}

