import java.util.ArrayList;
import java.util.List;

/**
 * Created by Valued Customer on 7/6/2017.
 *
 * 448. Find All Numbers Disappeared in an Array
 */
public class p448 {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> result = new ArrayList<>();
        if (nums == null || nums.length == 0) return result;
        for (int i = 1; i <= nums.length; i++) {
            while (i != nums[i-1] && nums[i-1] <= nums.length && nums[i-1] >= 1) {
                if (nums[nums[i-1]-1] == nums[i-1]) break;
                swap(nums, i-1, nums[i-1]-1);
            }
        }
        for (int i = 1; i <= nums.length; i++) {
            if (nums[i-1] != i) result.add(i);
        }
        return result;
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
