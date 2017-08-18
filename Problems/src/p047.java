import java.util.*;

/**
 * Created by larryliu on 7/31/16.
 * 47. Permutations II
 * Given a collection of numbers that might contain duplicates, return all possible unique permutations.

 For example,
 [1,1,2] have the following unique permutations:
 [
 [1,1,2],
 [1,2,1],
 [2,1,1]
 ]
 */
public class p047 {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new LinkedList<>();
        Arrays.sort(nums);
        dfs(nums, res, 0);
        return res;
    }

    private void dfs(int[] nums, List<List<Integer>> res, int i) {
        if (i == nums.length-1) {
            List<Integer> list = new LinkedList<>();
            for (int n: nums) list.add(n);
            res.add(list);
            return;
        }
        Set<Integer> visited = new HashSet<>();
        for (int j = i; j < nums.length; j++) {
            if (visited.contains(nums[j])) continue;
            visited.add(nums[j]);
            swap(nums, i, j);
            dfs(nums, res,i+1);
            swap(nums, i, j);
        }
    }
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        p047 sol = new p047();
        int[] nums = new int[]{1,1,2,2};
        List<List<Integer>> result = sol.permuteUnique(nums);
        System.out.println("result = [");
        for (List<Integer> list : result) {
            System.out.print("[");
            for (int i : list) System.out.print(i + ",");
            System.out.print("]\n");
        }
        System.out.println("]");
    }
}
