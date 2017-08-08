/**
 * Created by Valued Customer on 7/4/2017.
 *
 * 238. Product of Array Except Self
 */
public class p238 {
    public int[] productExceptSelf(int[] nums) {
        int[] result = new int[nums.length];
        result[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            result[i] = nums[i-1] * result[i-1];
        }
        int k = 1;
        for (int i = nums.length-1; i >= 0; i--) {
            result[i] = k * result[i];
            k *= nums[i];
        }
        return result;
    }
}
