import java.util.*;

/**
 * Created by larryliu on 7/31/16.
 * 40. Combination Sum II
 * Given a collection of candidate numbers (C) and a target number (T), find all unique combinations in C where the candidate numbers sums to T.

 Each number in C may only be used once in the combination.

 Note:
 All numbers (including target) will be positive integers.
 The solution set must not contain duplicate combinations.
 For example, given candidate set [10, 1, 2, 7, 6, 1, 5] and target 8,
 A solution set is:
 [
 [1, 7],
 [1, 2, 5],
 [2, 6],
 [1, 1, 6]
 ]
 */
public class p040 {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Map<Integer, Set<List<Integer>>> map = new HashMap<>();
        List<List<Integer>> result = new ArrayList<>();
        combinationSumHelper(candidates, 0, target, map);
        if (map.containsKey(target)) {
            Set<List<Integer>> set = new HashSet<>();
            for (List<Integer> list : map.get(target)) {
                List<Integer> value = new ArrayList<>();
                for (int i: list) value.add(candidates[i]);
                value.sort(Comparator.naturalOrder());
                if (!set.contains(value)) set.add(value);
            }
            result.addAll(set);
        }
        return result;

    }

    public void combinationSumHelper(int[] candidates, int start, int target, Map<Integer, Set<List<Integer>>> map) {
        // if (map.containsKey(target)) return;
        if (start >= candidates.length) return;
        if (target == 5)
            System.out.println("5");
        Set<List<Integer>> set = new HashSet<>();
        for (int i = start; i < candidates.length; i++) {
            if (i == 1)
                System.out.println("1");
            Set<List<Integer>> tempCombos = new HashSet<>();
            boolean isContain = map.containsKey(candidates[i]);
            if (isContain) tempCombos = map.remove(candidates[i]);

            if (target == candidates[i]) {
                List<Integer> combo = new ArrayList<>();
                combo.add(i);
                set.add(combo);
            } else if (target > candidates[i]) {
                combinationSumHelper(candidates, i+1, target - candidates[i], map);
                if (map.containsKey(target - candidates[i])) {
                    for (List<Integer> combo: map.get(target - candidates[i])) {
                        if (combo.contains(i)) continue;
                        boolean illegal = false;
                        for (int ind : combo) {
                            if (ind < start) {
                                illegal = true;
                                break;
                            }
                        }
                        if (illegal) continue;
                        List<Integer> comboCopy = new ArrayList<>(combo);
                        comboCopy.add(i);
                        comboCopy.sort(Comparator.naturalOrder());
                        if(!set.contains(comboCopy)) set.add(comboCopy);
                    }
                }
            }
            if (isContain) map.put(candidates[i], tempCombos);
        }
        if (set.size() > 0)
            map.put(target, set);
    }

    public static void main(String[] args) {
        p040 sol = new p040();
        int[] candidates = new int[]{1,3,1,3,2,5};
        List<List<Integer>> result = sol.combinationSum2(candidates, 8);
        System.out.println("result = [");
        for (List<Integer> list : result) {
            System.out.print("[");
            for (int i : list) System.out.print(i + ",");
            System.out.print("]\n");
        }
        System.out.println("]");
    }
}
