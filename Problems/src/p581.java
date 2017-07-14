/**
 * Created by larryliu on 7/12/17.
 *
 * 581. Shortest Unsorted Continuous Subarray
 *
 * Given an integer array, you need to find one continuous subarray that if you only sort this subarray in ascending order, then the whole array will be sorted in ascending order, too.

 You need to find the shortest such subarray and output its length.

 Example 1:
 Input: [2, 6, 4, 8, 10, 9, 15]
 Output: 5
 Explanation: You need to sort [6, 4, 8, 10, 9] in ascending order to make the whole array sorted in ascending order.
 Note:
 Then length of the input array is in range [1, 10,000].
 The input array may contain duplicates, so ascending order here means <=.
 */
public class p581 {

    public int findUnsortedSubarray(int[] nums) {
        if (nums == null || nums.length < 2) return 0;
        int n = nums.length;
        int begin = -1, end = -2;
        int max = nums[0], min = nums[n-1];
        for (int i = 0; i < n; i++) {
            max = Math.max(max, nums[i]);
            min = Math.min(min, nums[n-1-i]);
            if (max != nums[i]) end = i;
            if (min != nums[n-1-i]) begin = n-i-1;
        }
        return end - begin + 1;
    }
}
