/**
 * Created by Valued Customer on 8/5/2016.
 * 33. Search in Rotated Sorted Array
 * Suppose a sorted array is rotated at some pivot unknown to you beforehand.

 (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).

 You are given a target value to search. If found in the array return its index, otherwise return -1.

 you may assume no duplicate exists in the array.
 */
public class p033 {
    public int search(int[] nums, int target) {
        int lo = 0, hi = nums.length -1;
        while (lo <= hi) {
            int mid = (lo + hi) / 2;
            if (target == nums[lo]) return lo;
            if (target == nums[hi]) return hi;
            if (target == nums[mid]) return mid;
            if (nums[mid] < nums[lo]) {
                if (target < nums[mid] || target > nums[lo]) hi = mid - 1;
                else if (target > nums[mid] && target < nums[hi]) lo = mid + 1;
                else return -1;
            } else {
                if (target > nums[lo] && target < nums[mid]) hi = mid - 1;
                else if (target < nums[hi] || target > nums[mid]) lo = mid + 1;
                else return -1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        p033 sol = new p033();
        int[] nums = new int[]{1,3};
        System.out.println(sol.search(nums, 3));
    }
}
