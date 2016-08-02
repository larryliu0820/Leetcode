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
//        boolean[] canJump = new boolean[nums.length];
//        canJumpHelper(nums, 0, canJump);
//        return canJump[0];
        int lastJumpInd = nums.length - 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            if (nums[i] == 0) continue;
            if (nums[i] + i >= lastJumpInd) lastJumpInd = i;
        }
        return lastJumpInd == 0;
    }

    public void canJumpHelper(int[] nums, int index, boolean[] canJump) {
        if (index == nums.length - 1 || nums[index] >= nums.length - index - 1) {
            canJump[index] = true;
            return;
        }
        for (int i = index + 1; i <= index + nums[index]; i++) {
            if (i > nums.length - 1) return;
            canJumpHelper(nums, i, canJump);
            if (canJump[i]) {
                canJump[index] = true;
                break;
            }
        }

    }

    public static void main(String[] args) {
        p055 sol = new p055();
        int[] nums = new int[]{2,3,1,1,4};
        System.out.println("result = " + sol.canJump(nums));
    }
}
