/**
 * Created by Valued Customer on 7/28/2017.
 * 189. Rotate Array
 */
public class p189 {
    public void rotate(int[] nums, int k) {
        k %= nums.length;
        helper(nums, 0, nums.length-1);
        helper(nums, 0, k-1);
        helper(nums, k, nums.length-1);
    }

    private void helper(int[] nums, int i, int j) {
        while (i < j) {
            int temp = nums[i];
            nums[i++] = nums[j];
            nums[j--] = temp;
        }
    }
}
