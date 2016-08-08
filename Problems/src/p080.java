/**
 * Created by Valued Customer on 8/5/2016.
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
        if(nums.length == 1) return 1;
        int itr = 0;
        int diffItr = 1;
        int dup = nums[0], occur = 1;
        for (; diffItr < nums.length; diffItr++) {
            if (nums[diffItr] == dup) {
                if (occur < 2) nums[++itr] = nums[diffItr];
                occur++;
            } else {
                dup = nums[diffItr];
                occur = 1;
                nums[++itr] = dup;
            }

        }
        System.out.print("[");
        for (int i : nums) System.out.print(i + ",");
        System.out.print("]\n");
        return itr+1;
    }

    public static void main(String[] args) {
        p080 sol = new p080();
        int[] nums = new int[]{1,1,1,1,2};
        System.out.println(sol.removeDuplicates(nums));
    }
}
