/**
 * Created by mengwliu on 7/29/16.
 * 34. Search for a Range
 * Given a sorted array of integers, find the starting and ending position of a given target value.

 Your algorithm's runtime complexity must be in the order of O(log n).

 If the target is not found in the array, return [-1, -1].

 For example,
 Given [5, 7, 7, 8, 8, 10] and target value 8,
 return [3, 4].
 */
public class p034 {
    public int[] searchRange(int[] nums, int target) {
        return searchHelper(nums, target, 0, nums.length-1);
    }

    public int[] searchHelper(int[] nums, int target, int begin, int end) {
        System.out.println("begin = " + begin + ", end = " + end);
        if (nums[begin] > target || nums[end] < target) return new int[]{-1,-1};
        if (nums[begin] == target && nums[end] == target) return new int[]{begin, end};
        if (begin == end) {
            if (nums[begin] == target) return new int[]{begin,begin};
            else return new int[]{-1,-1};
        }
        int midInd = begin + (end - begin) / 2;
        int mid = nums[midInd];
        int[] result;
        if (mid > target) {
            result = searchHelper(nums, target, begin, midInd - 1);
        } else if (mid < target) {
            result = searchHelper(nums, target, midInd + 1, end);
        } else {
            result = new int[]{midInd, midInd};
            if (midInd - 1 >= begin) {
                int[] leftResult = searchHelper(nums, target, begin, midInd - 1);
                if (leftResult[0] != -1 && leftResult[1] != -1) {
                    result[0] = leftResult[0];
                }
            }

            if (midInd + 1 <= end) {
                int[] rightResult = searchHelper(nums, target, midInd + 1, end);

                if (rightResult[0] != -1 && rightResult[1] != -1) {
                    result[1] = rightResult[1];
                }
            }
        }
        return result;
    }
    public static void main(String[] args) {
        p034 sol = new p034();
        //int[] input = new int[]{5, 7, 7, 8, 8, 10};
        int[] input = new int[]{1,3};
        int[] result = sol.searchRange(input, 1);
        System.out.println("result[0] = " + result[0] + ", result[1] = " + result[1]);
    }
}
