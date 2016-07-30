import java.util.*;

/**
 * Created by mengwliu on 7/29/16.
 * 18. 4Sum
 * Given an array S of n integers, are there elements a, b, c, and d in S such that a + b + c + d = target? Find all unique quadruplets in the array which gives the sum of target.

 Note: The solution set must not contain duplicate quadruplets.

 For example, given array S = [1, 0, -1, 0, -2, 2], and target = 0.

 A solution set is:
 [
 [-1,  0, 0, 1],
 [-2, -1, 1, 2],
 [-2,  0, 0, 2]
 ]

 */
public class p018 {
    public List<List<Integer>> fourSum(int[] num, int target) {
        Arrays.sort(num);
        HashSet<List<Integer>> pairSet = new HashSet<>();
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < num.length - 3; i++) {
            for (int j = i + 1; j < num.length - 2; j++) {
                List<Integer> firstPair = new ArrayList<>();
                firstPair.add(num[i]);
                firstPair.add(num[j]);
                if (!pairSet.contains(firstPair)) {
                    pairSet.add(firstPair);
                    List<List<Integer>> lastPairs = twoSum(num, j + 1, num.length-1, target-num[i]-num[j]);
                    for (List<Integer> lastPair : lastPairs) {
                        lastPair.addAll(firstPair);
                        result.add(lastPair);
                    }
                }
            }
        }
        return result;
    }

    public List<List<Integer>> twoSum(int[] num, int begin, int end, int target) {
        HashSet<List<Integer>> pairSet = new HashSet<>();
        while (begin < end) {
            int sum = num[begin] + num[end];
            if (target == sum) {
                List<Integer> pair = new ArrayList<>();
                pair.add(num[begin]);
                pair.add(num[end]);
                if (!pairSet.contains(pair))
                    pairSet.add(pair);
                end--;
                begin++;
            } else if (target < sum) {
                end--;
            } else {
                begin++;
            }
        }
        return new ArrayList<>(pairSet);
    }

    public static void main(String[] args) {
        p018 sol = new p018();
        int[] num = new int[]{-3,-1,0,2,4,5};
        List<List<Integer>> result = sol.fourSum(num, 0);
        for (int i = 0; i < result.size(); i++) {
            System.out.print("result[" + i + "] = [");
            for (int j : result.get(i)) {
                System.out.print(j + ", ");
            }
            System.out.print("]\n");
        }
    }
}
