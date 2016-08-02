import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
        List<List<Integer>> res = new ArrayList<>();
        if(nums == null || nums.length == 0) {
            return res;
        }
        boolean[] visited = new boolean[nums.length];
        List<Integer> result = new ArrayList<>();
        Arrays.sort(nums);
        dfs(nums, visited, result, res);
        return res;
    }

    public void dfs(int[] nums, boolean[] visited, List<Integer> result, List<List<Integer>> res) {
        if (result.size() == nums.length) {
            List<Integer> list = new ArrayList<>();
            list.addAll(result);
            res.add(list);
        }
        for (int i = 0; i < nums.length; i++) {
            if (visited[i]) continue;
            if (i > 0 && nums[i] == nums[i-1] && (!visited[i-1])) continue;
            result.add(nums[i]);
            visited[i] = true;
            dfs(nums, visited, result, res);
            visited[i] = false;
            result.remove(result.size()-1);
        }
    }

    public static void main(String[] args) {
        p047 sol = new p047();
        int[] nums = new int[]{1,1,2};
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
