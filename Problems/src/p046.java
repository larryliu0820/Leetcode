import java.util.LinkedList;
import java.util.List;

/**
 * Created by Valued Customer on 8/8/2017.
 * 46. Permutations
 */
public class p046 {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new LinkedList<>();
        permuteHelper(result, nums, 0);
        return result;
    }

    private void permuteHelper(List<List<Integer>> result, int[] nums, int i) {
        if (i == nums.length-1) {
            List<Integer> ans = new LinkedList<>();
            for (int n: nums) ans.add(n);
            result.add(ans);
        }
        for (int j = i; j < nums.length; j++) {
            swap(nums, i, j);
            permuteHelper(result, nums, i+1);
            swap(nums, i, j);
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
