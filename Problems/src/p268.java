/**
 * Created by Valued Customer on 7/26/2017.
 *
 * 268. Missing Number
 */
public class p268 {
    public int missingNumber(int[] nums) {
        int i = 0;
        while (i < nums.length) {
            if (i == nums[i] || nums[i] >= nums.length) i++;
            else swap(nums, i, nums[i]);
        }
        for (i = 0; i < nums.length; i++)
            if (nums[i] != i) return i;
        return i;
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
