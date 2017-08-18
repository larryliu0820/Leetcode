/**
 * Created by Valued Customer on 8/1/2016.
 * 55. Jump Game
 * Given an array of non-negative integers, you are initially positioned at the first index of the array.

 Each element in the array represents your maximum jump length at that position.

 Determine if you are able to reach the last index.

 For example:
 A = [2,3,1,1,4], return true.

 A = [3,2,1,0,4], return false.
 */
public class p055 {
    public boolean canJump(int[] nums) {
        int last = nums.length -1;
        for (int i = nums.length - 2; i >= 0; i--) {
            if (i + nums[i] >= last) last = i;
        }
        return last<=0;
    }

    public static void main(String[] args) {
        p055 sol = new p055();
        int[] nums = new int[]{0,2,3};
        System.out.println("result = " + sol.canJump(nums));
    }
}
