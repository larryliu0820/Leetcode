/**
 * Created by Valued Customer on 8/11/2016.
 * 162. Find Peak Element
 * A peak element is an element that is greater than its neighbors.

 Given an input array where num[i] ≠ num[i+1], find a peak element and return its index.

 The array may contain multiple peaks, in that case return the index to any one of the peaks is fine.

 You may imagine that num[-1] = num[n] = -∞.

 For example, in array [1, 2, 3, 1], 3 is a peak element and your function should return the index number 2.
 */
public class p162 {
    public int findPeakElement(int[] nums) {
        if (nums.length < 3) return -1;
        int lo = 0, hi = nums.length-1;
        while (lo < hi) {
            int mid1 = (lo + hi) / 2;
            int mid2 = mid1 + 1;
            if (nums[mid1] < nums[mid2]) {
                lo = mid2;
            } else
                hi = mid1;
        }
        return lo;
    }
}
