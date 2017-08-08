/**
 * Created by Valued Customer on 7/26/2017.
 *
 * 268. Missing Number
 */
public class p268 {
    public int missingNumber(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            while (nums[i] < nums.length && nums[i] != i)
                swap(nums, i, nums[i]);
        }
        for (int i = 0; i < nums.length; i++) if (nums[i] != i) return i;
        return nums.length;
    }

    private void swap(int[] A, int i, int j) {
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }
}
