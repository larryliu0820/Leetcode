/**
 * Created by Valued Customer on 8/18/2016.
 * 280. Wiggle Sort
 * Given an unsorted array nums, reorder it in-place such that nums[0] <= nums[1] >= nums[2] <= nums[3]....

 For example, given nums = [3, 5, 2, 1, 6, 4], one possible answer is [1, 6, 2, 5, 3, 4].
 */
public class p280 {
    public void wiggleSort(int[] nums) {
        if (nums == null || nums.length < 2) return;
        int i = 1;
        for (; i < nums.length - 1; i+=2) {
            if (nums[i] >= nums[i - 1] && nums[i] >= nums[i + 1]) continue;
            else reorder3(nums, i);
        }
        if (i == nums.length-1 && nums[i-1] > nums[i]) swap(nums, i-1, i);

    }
    public void reorder3(int[] nums, int ind) {
        if (ind+1 > nums.length-1 || ind-1 < 0) return;
        if (nums[ind] >= nums[ind-1] && nums[ind] >= nums[ind+1]) return;
        else if (nums[ind-1] >= nums[ind] && nums[ind-1] >= nums[ind+1]) {
            swap(nums, ind, ind-1);
            reorder3(nums, ind-2);
        } else {
            swap(nums, ind, ind+1);
            reorder3(nums,ind+2);
        }
    }

    public void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
