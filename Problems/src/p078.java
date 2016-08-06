import java.util.ArrayList;
import java.util.List;

/**
 * Created by mengwliu on 8/5/16.
 * 78. Subsets
 *  Given a set of distinct integers, nums, return all possible subsets.

 Note: The solution set must not contain duplicate subsets.

 For example,
 If nums = [1,2,3], a solution is:

 [
 [3],
 [1],
 [2],
 [1,2,3],
 [1,3],
 [2,3],
 [1,2],
 []
 ]

 */
public class p078 {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        result.add(new ArrayList<>());
        if (nums == null || nums.length == 0) return result;
        for (int i = 0; i < nums.length; i ++) {
            int currInt = nums[i];
            int resultSize = result.size();
            for (int j = 0; j < resultSize; j++) {
                List<Integer> copy = new ArrayList<>(result.get(j));
                copy.add(currInt);
                result.add(copy);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        p078 sol = new p078();
        int[] nums = new int[]{1,2,3};
        List<List<Integer>> result = sol.subsets(nums);
        System.out.println("result = " + result.toString());
    }
}
