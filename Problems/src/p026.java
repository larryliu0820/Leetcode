/**
 * Created by Valued Customer on 8/5/2016.
 * 26. Remove Duplicates from Sorted Array
 * Given a sorted array, remove the duplicates in place such that each element appear only once and return the new length.

 Do not allocate extra space for another array, you must do this in place with constant memory.

 For example,
 Given input array nums = [1,1,2],

 Your function should return length = 2, with the first two elements of nums being 1 and 2 respectively. It doesn't matter what you leave beyond the new length.
 */
public class p026 {
    public int removeDuplicates(int[] nums) {
        if (nums == null) return 0;
        if (nums.length <= 1) return nums.length;
        int i = 0, j = 1;
        for (;j < nums.length; j++) {
            if (nums[i] != nums[j]) {
                nums[++i] = nums[j];
            }
        }
        return i;
    }

    public static void main(String[] args) {
        p026 sol = new p026();
        int[] nums = new int[]{1,1,2,2,2,2,5,5,5};
        System.out.println(sol.removeDuplicates(nums));
    }
}
