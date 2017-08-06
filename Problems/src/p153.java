/**
 * Created by Valued Customer on 8/5/2017.
 * 153. Find Minimum in Rotated Sorted Array
 */
public class p153 {
    public int findMin(int[] nums) {
        int lo = 0, hi = nums.length -1;
        while (lo < hi) {
            int mid = (lo + hi) / 2;
            if (nums[mid] == nums[lo]) return nums[hi]<nums[mid]?nums[hi]:nums[mid];
            if (nums[mid] == nums[hi]) return nums[lo]<nums[mid]?nums[lo]:nums[mid];

            if (nums[lo] > nums[hi]) {
                if (nums[mid] > nums[lo]) lo = mid + 1;
                else hi = mid - 1;
            } else return nums[lo];
        }
        return nums[lo];

    }
}
