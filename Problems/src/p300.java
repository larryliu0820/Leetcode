import java.util.ArrayList;
import java.util.List;

/**
 * Created by Valued Customer on 7/18/2017.
 * 300. Longest Increasing Subsequence
 */
public class p300 {
    public int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int[] max = new int[nums.length];
        max[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    max[i] = Math.max(max[j] + 1, max[i]);
                }
            }
        }
        return max[nums.length - 1];
    }

    public int lengthOfLIS2(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        List<Integer> increasingList = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (increasingList.size() == 0) increasingList.add(nums[i]);
            else if (nums[i] > increasingList.get(increasingList.size()-1)) increasingList.add(nums[i]);
            else {
                int location = binarySearch(increasingList, nums[i]);
                increasingList.set(location, nums[i]);
            }
        }
        return increasingList.size();
    }

    private int binarySearch(List<Integer> nums, int target) {
        int begin = 0, end = nums.size()-1;
        while (begin <= end) {
            int mid = (begin + end) / 2;
            if (nums.get(mid) >= target && (mid == 0 || nums.get(mid-1) <= target)) {
                return mid;
            } else if (nums.get(mid) < target) {
                begin = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return begin;
    }

}
