/**
 * Created by Valued Customer on 8/3/2017.
 * 75. Sort Colors
 */
public class p075 {
    public void sortColors(int[] nums) {
        if (nums == null || nums.length == 0) return;
        int j = 0, k = nums.length - 1;
        for (int i = 0; i <= k; i++) {
            if (nums[i] == 0 && i != j)
                swap(nums, i--, j++);
            else if (nums[i] == 2 && i != k)
                swap(nums, i--, k--);
        }

    }
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
