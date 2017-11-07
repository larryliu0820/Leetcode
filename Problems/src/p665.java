/**
 * Created by mengwliu on 11/6/17.
 * 665. Non-decreasing Array
 */
public class p665 {
    public boolean checkPossibility(int[] nums) {
        if (nums == null || nums.length < 2) return true;
        boolean hasOne = false;
        for (int i = 0; i < nums.length -1; i++) {
            if (nums[i] - nums[i+1] > 0) {
                if (hasOne) return false;
                else {
                    hasOne = true;
                    if (i == 0 || nums[i+1] >= nums[i-1]) nums[i] = nums[i+1];
                    else nums[i+1] = nums[i];
                }
            }
        }
        return true;
    }
}
