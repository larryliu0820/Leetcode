import java.lang.reflect.Array;
import java.util.*;

/**
 * Created by Valued Customer on 7/30/2016.
 * 39. Combination Sum
 * Given a set of candidate numbers (C) and a target number (T), find all unique combinations in C where the candidate numbers sums to T.

 The same repeated number may be chosen from C unlimited number of times.

 Note:
 All numbers (including target) will be positive integers.
 The solution set must not contain duplicate combinations.
 For example, given candidate set [2, 3, 6, 7] and target 7,
 A solution set is:
 [
 [7],
 [2, 2, 3]
 ]
 */
public class p039 {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        HashMap<Integer, HashSet<List<Integer>>> map = new HashMap<>();
        combinationSumHelper(candidates, target, map);
        return new ArrayList<>(map.get(target));
    }

    public void combinationSumHelper(int[] candidates, int target, HashMap<Integer, HashSet<List<Integer>>> map) {
        if (target > 0 && map.containsKey(target)) return;
        // List<List<Integer>> combos = new ArrayList<>();
        HashSet<List<Integer>> set = new HashSet<>();
        for (int i : candidates) {
            if (target == i) {
                List<Integer> list = new ArrayList<>();
                list.add(i);
                // combos.add(list);
                set.add(list);
                continue;
            }
            if (target < i) continue;
            combinationSumHelper(candidates, target - i, map);

            if (map.containsKey(target - i)) {
                List<List<Integer>> otherCombos = new ArrayList<>();
                for (List<Integer> combo : map.get(target - i)) {
                    List<Integer> comboCopy = new ArrayList<>(combo);
                    comboCopy.add(i);
                    comboCopy.sort(Comparator.naturalOrder());
                    if (!set.contains(comboCopy)) {
                        otherCombos.add(comboCopy);
                        set.add(comboCopy);
                    }
                }
                // combos.addAll(otherCombos);

            }

        }

        map.put(target, set);
    }

    public static void main(String[] args) {
        p039 sol = new p039();
        int[] candidates = new int[]{2,3,6,7};
        List<List<Integer>> result = sol.combinationSum(candidates, 7);
        System.out.println("result = [");
        for (List<Integer> list : result) {
            System.out.print("[");
            for (int i : list) System.out.print(i + ",");
            System.out.print("]\n");
        }
        System.out.println("]");
    }
}
