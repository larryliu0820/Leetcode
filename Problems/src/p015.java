import java.util.*;

/**
 * Created by larryliu on 9/18/16.
 * 15. 3Sum
 * Given an array S of n integers, are there elements a, b, c in S such that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.

 Note: The solution set must not contain duplicate triplets.

 For example, given array S = [-1, 0, 1, 2, -1, -4],

 A solution set is:
 [
 [-1, 0, 1],
 [-1, -1, 2]
 ]
 */
public class p015 {
    public List<List<Integer>> threeSum(int[] num) {
        List<List<Integer>> result = new ArrayList<>();
        if (num == null || num.length == 0) return result;
        Arrays.sort(num);
        int last = 0;
        for (int i = 0; i < num.length - 2; i++) {
            if (i == 0) last = num[0];
            else {
                if (last == num[i]) continue;
                last = num[i];
            }
            int begin = i+1, end = num.length - 1;
            while (begin < end) {
                int currSum = num[begin] + num[end];
                if (currSum + num[i] == 0) {
                    result.add(Arrays.asList(num[i], num[begin], num[end]));
                    while (begin < end && num[begin] == num[++begin]);
                    while (begin < end && num[end] == num[--end]);

                } else if (currSum + num[i] > 0) {
                    end--;
                } else begin++;
            }
        }
        return result;
    }
}
