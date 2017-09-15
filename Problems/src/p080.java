/**
 * Created by Valued Customer on 9/6/2017.
 * 80. Remove Duplicates from Sorted Array II
 * Follow up for "Remove Duplicates":
 What if duplicates are allowed at most twice?

 For example,
 Given sorted array nums = [1,1,1,2,2,3],

 Your function should return length = 5, with the first five elements of nums being 1, 1, 2, 2 and 3. It doesn't matter what you leave beyond the new length.
 */
public class p080 {
    public int removeDuplicates(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        int j = 0;
        boolean dup = false;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[j]) {
                if (!dup) {
                    nums[++j] = nums[i];
                    dup = true;
                }
            } else {
                dup = false;
                nums[++j] = nums[i];
            }
        }
//        System.out.print("[");
//        for (int i : nums) System.out.print(i + ",");
//        System.out.print("]\n");
        return j+1;
    }

    public static void main(String[] args) {
        p080 sol = new p080();
        int[] nums = new int[]{1,1,1,1,2};
        System.out.println(sol.removeDuplicates(nums));
    }
}
