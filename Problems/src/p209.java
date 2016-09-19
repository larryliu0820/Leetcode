import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by Valued Customer on 9/18/2016.
 * 209. Minimum Size Subarray Sum
 * Given an array of n positive integers and a positive integer s, find the minimal length of a subarray of which the
 * sum ≥ s. If there isn't one, return 0 instead.

 For example, given the array [2,3,1,2,4,3] and s = 7,
 the subarray [4,3] has the minimal length under the problem constraint.
 */
public class p209 {
    public int minSubArrayLen(int s, int[] nums) {
        int len = nums.length + 1;
        int tail = 0;
        int sum = 0;
        for (int i = 0; i < nums.length; i++){
            sum += nums[i];
            while (sum >= s) {
                len = Math.min(len, i - tail + 1);
                sum -= nums[tail++];
            }
        }

        return len == nums.length+1?0:len;
    }

    public static void main(String args[]) {
        p209 sol = new p209();
        int[] nums = new int[]{1,2,3,4,5};
        System.out.println(sol.minSubArrayLen(11,nums));
    }
}
