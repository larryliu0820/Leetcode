import javax.transaction.TransactionRequiredException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Valued Customer on 8/7/2016.
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
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        if(root == null) return result;
        dfs(root, sum, path, result);
        return result;
    }

    public void dfs(TreeNode root, int sum, List<Integer> path, List<List<Integer>> result) {
        if (root == null) return;
        path.add(root.val);
        if (sum == root.val && root.left == null && root.right == null) {
            List<Integer> copy = new ArrayList<>();
            copy.addAll(path);
            result.add(copy);
            path.remove(path.size()-1);
            return;
        }
        if(root.left != null) {
            dfs(root.left, sum - root.val, path, result);
        }
        if(root.right != null) {
            dfs(root.right, sum - root.val, path, result);
        }
        path.remove(path.size()-1);
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
