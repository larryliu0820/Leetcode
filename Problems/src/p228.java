import java.util.ArrayList;
import java.util.List;

/**
 * Created by Valued Customer on 8/14/2016.
 * 228. Summary Ranges
 * Given a sorted integer array without duplicates, return the summary of its ranges.

 For example, given [0,1,2,4,5,7], return ["0->2","4->5","7"].
 */
public class p228 {
    public List<String> summaryRanges(int[] nums) {
        List<String> result = new ArrayList<String>();
        if (nums == null || nums.length == 0) return result;
        if (nums.length == 1) {
            result.add(Integer.toString(nums[0]));
            return result;
        }
        int lower = 0, upper = 1;
        for (; upper < nums.length; upper++) {
            if (nums[upper - 1] < nums[upper] - 1) {
                if (lower == upper) {
                    result.add(Integer.toString(nums[lower]));
                } else {
                    result.add("" + nums[lower] + "->" + nums[upper - 1]);
                }
                lower = upper;
            }
        }
        if (lower == nums.length-1) {
            result.add(Integer.toString(nums[lower]));
        } else {
            result.add("" + nums[lower] + "->" + nums[nums.length-1]);
        }

        return result;
    }
}
