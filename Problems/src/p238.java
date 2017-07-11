/**
 * Created by Valued Customer on 7/4/2017.
 *
 * 238. Product of Array Except Self
 */
public class p238 {
    public int[] productExceptSelf(int[] nums) {
        int[] res = new int[nums.length];
        if (nums.length < 2) return res;
        res[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            res[i] = res[i-1] * nums[i-1];
        }
        int right = 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            res[i] *= right;
            right *= nums[i];
        }
        return res;
    }
}
