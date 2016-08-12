import java.util.ArrayList;
import java.util.List;

/**
 * Created by Valued Customer on 8/11/2016.
 * 163. Missing Ranges
 * Given a sorted integer array where the range of elements are [lower, upper] inclusive, return its missing ranges.

 For example, given [0, 1, 3, 50, 75], lower = 0 and upper = 99, return ["2", "4->49", "51->74", "76->99"].
 */
public class p163 {
    public List<String> findMissingRanges(int[] nums, int lower, int upper) {
        List<String> result = new ArrayList<>();
        if (nums.length == 0) {
            String res = null;
            if (upper - lower > 0) res = lower + "->" + upper;
            else res = Integer.toString(lower);
            result.add(res);
            return result;
        }
        int last = lower;
        if (nums[0] - lower >= 2) result.add(lower + "->" + (nums[0]-1));
        else if (nums[0] - lower == 1) result.add(Integer.toString(lower));
        last = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] - last > 2) {
                result.add((last+1) + "->" + (nums[i]-1));
            } else if (nums[i] - last == 2) {
                result.add(Integer.toString(last + 1));
            }
            last = nums[i];
        }

        if (upper - last >= 2) result.add((last+1) + "->" + (upper));
        else if (upper - last == 1) result.add(Integer.toString(upper));
        return result;
    }
}
