import javax.print.attribute.IntegerSyntax;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by mengwliu on 9/7/16.
 * 360. Sort Transformed Array
 * Given a sorted array of integers nums and integer values a, b and c.
 * Apply a function of the form f(x) = ax2 + bx + c to each element x in the array.

 The returned array must be in sorted order.

 Expected time complexity: O(n)

 Example:

 nums = [-4, -2, 2, 4], a = 1, b = 3, c = 5,

 Result: [3, 9, 15, 33]

 nums = [-4, -2, 2, 4], a = -1, b = 3, c = 5

 Result: [-23, -5, 1, 7]

 */
public class p360 {
    public int[] sortTransformedArray(int[] nums, int a, int b, int c) {
        if (nums == null || nums.length == 0) return null;

        List<Integer> inc = new LinkedList<>();
        List<Integer> dec = new LinkedList<>();
        int[] results = new int[nums.length];
        if (a == 0) {
            for (int i = 0; i < nums.length; i++) {
                int result = b * nums[i] + c;
                if (b >= 0) results[i] = result;
                else results[results.length - i - 1] = result;
            }
            return results;
        }
        double axis = - ((double)b / (double)(2*a));
        for (int i : nums) {
            int result = a*i*i+b*i+c;
            if (i > axis ^ a > 0) {
                dec.add(result);
            } else {
                inc.add(result);
            }
        }
        int i = 0;
        int j = dec.size()-1;
        int k = 0;
        while (i < inc.size() || j >= 0) {
            if (i < inc.size() && j < 0){
                results[k++] = inc.get(i++);
                continue;
            } else if (i >= inc.size() && j >= 0){
                results[k++] = dec.get(j--);
                continue;
            }
            if (dec.get(j) > inc.get(i)) {
                results[k++] = inc.get(i++);
            } else {
                results[k++] = dec.get(j--);
            }
        }
        return results;
    }

    public static void main(String[] args) {
        p360 sol = new p360();
        sol.sortTransformedArray(new int[]{-99,-98,-94,-93,-93,-93,-88,-83,-77,-77,-77,-74,-74,-72,-71,-70,-67,-64,-63,-62,-61,-58,-56,-54,-54,-53,-51,-51,-50,-48,-46,-45,-42,-41,-35,-31,-22,-22,-20,-20,-16,-16,-12,-11,-8,-3,-2,-1,0,1,3,4,6,9,10,11,11,11,12,13,26,27,29,31,32,34,36,42,48,49,54,56,59,62,62,65,65,69,70,72,73,74,75,82,85,86,91,92,92,97,98}, 13, 22, -16);
    }
}
