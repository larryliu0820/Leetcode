import java.util.HashMap;
import java.util.Map;

/**
 * Created by Valued Customer on 10/12/2017.
 *
 * 437. Path Sum III
 *
 * You are given a binary tree in which each node contains an integer value.

 Find the number of paths that sum to a given value.

 The path does not need to start or end at the root or a leaf, but it must go downwards (traveling only from parent nodes to child nodes).

 The tree has no more than 1,000 nodes and the values are in the range -1,000,000 to 1,000,000.

 Example:

 root = [10,5,-3,3,2,null,11,3,-2,null,1], sum = 8

       10
      /  \
     5   -3
    / \    \
   3   2   11
  / \   \
 3  -2   1

 Return 3. The paths that sum to 8 are:

 1.  5 -> 3
 2.  5 -> 2 -> 1
 3. -3 -> 11
 */
public class p437 {
    public int pathSum(TreeNode root, int sum) {
        Map<Integer, Integer> preSum = new HashMap<>();
        preSum.put(0, 1);
        return pathSumHelper(root, 0, sum, preSum);
    }

    private int pathSumHelper(TreeNode root, int currSum, int target, Map<Integer, Integer> preSum) {
        if (root == null) return 0;

        currSum += root.val;
        int res = preSum.getOrDefault(currSum - target, 0);

        preSum.put(currSum, preSum.getOrDefault(currSum, 0) + 1);
        res += pathSumHelper(root.left, currSum, target, preSum) + pathSumHelper(root.right, currSum, target, preSum);
        preSum.put(currSum, preSum.get(currSum) - 1);

        return res;
    }

}
