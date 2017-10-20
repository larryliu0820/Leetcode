import javax.transaction.TransactionRequiredException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * Created by Valued Customer on 10/12/17.
 * 113. Path Sum II
 * Given a binary tree and a sum, find all root-to-leaf paths where each path's sum equals the given sum.

 For example:
 Given the below binary tree and sum = 22,
 5
 / \
 4   8
 /   / \
 11  13  4
 /  \    / \
 7    2  5   1
 return
 [
 [5,4,11,2],
 [5,8,4,5]
 ]
 */
public class p113 {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> res = new LinkedList<>();
        helper(root, 0, sum, res, new Stack<>());
        return res;
    }

    private void helper(TreeNode root, int curr, int target, List<List<Integer>> res, Stack<Integer> path) {
        if (root == null) return;
        curr += root.val;
        path.push(root.val);

        if (root.left == null && root.right == null) {
            if (curr == target) res.add(new LinkedList<>(path));
        }

        helper(root.left, curr, target, res, path);

        helper(root.right, curr, target, res, path);

        path.pop();
    }

    public static void main(String[] args) {
        p113 sol = new p113();
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.right = new TreeNode(8);
        root.left.left = new TreeNode(11);
        root.left.left.left = new TreeNode(7);
        root.left.left.right = new TreeNode(2);
        root.right.left = new TreeNode(13);
        root.right.right = new TreeNode(4);
        root.right.right.left = new TreeNode(5);
        root.right.right.right = new TreeNode(1);
        List<List<Integer>> result = sol.pathSum(root, 22);
        System.out.println(result.toString());
    }
}
