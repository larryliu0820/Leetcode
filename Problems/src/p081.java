/**
 * Created by Valued Customer on 8/5/2016.
 * 81. Search in Rotated Sorted Array II
 * Follow up for "Search in Rotated Sorted Array":
 What if duplicates are allowed?

 Would this affect the run-time complexity? How and why?

 Write a function to determine if a given target is in the array.
 */
public class p081 {
    public boolean search(int[] nums, int target) {
        if (nums == null || nums.length == 0) return false;
        int begin = 0, end = nums.length-1;
        return searchHelper(nums, target, begin, end);
    }

    public boolean searchHelper(int[] nums, int target, int begin, int end) {
        if (begin > end) return false;
        System.out.println("begin = " + begin + ", end = " + end);
        int mid = (begin + end) / 2;
        if (target == nums[mid]) return true;
        if (nums[mid] > nums[begin]) {
            if (target < nums[begin] || target > nums[mid]) {
                begin = mid + 1;
            } else {
                end = mid - 1;
            }
            return searchHelper(nums, target, begin, end);
        } else if (nums[mid] < nums[begin]) {
            if (target < nums[mid] || target > nums[end]) {
                end = mid - 1;
            } else {
                begin = mid + 1;
            }
            return searchHelper(nums, target, begin, end);
        } else {
            return searchHelper(nums, target, begin, mid-1) || searchHelper(nums, target, mid+1, end);
        }
    }
    public static void main(String[] args) {
        p081 sol = new p081();
        int[] nums = new int[]{1,2,3,1,1,1,1,1};
        System.out.println(sol.search(nums, 4));
    }
}
