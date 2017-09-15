import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by mengwliu on 9/5/17.
 * 78. Subsets
 *  Given a set of distinct integers, nums, return all possible subsets.

 Note: The solution set must not contain duplicate subsets.

 For example,
 If nums = [1,2,3], a solution is:

 [
 [3],
 [1],
 [2],
 [1,2,3],
 [1,3],
 [2,3],
 [1,2],
 []
 ]

 */
public class p078 {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new LinkedList<>();
        res.add(new LinkedList<>());
        for (int i : nums) {
            List<List<Integer>> temp = new LinkedList<>();
            for (List<Integer> list: res) {
                temp.add(new LinkedList<>(list));
                list.add(i);
                temp.add(new LinkedList<>(list));
            }
            res = temp;
        }

        return res;
    }

    public static void main(String[] args) {
        p078 sol = new p078();
        int[] nums = new int[]{1,2,3};
        List<List<Integer>> result = sol.subsets(nums);
        System.out.println("result = " + result.toString());
    }
}
