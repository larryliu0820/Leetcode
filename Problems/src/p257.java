import java.util.LinkedList;
import java.util.List;

/**
 * Created by Valued Customer on 9/14/2016.
 * 257. Binary Tree Paths
 * Given a binary tree, return all root-to-leaf paths.

 For example, given the following binary tree:

    1
  /   \
 2     3
  \
   5
 All root-to-leaf paths are:

 ["1->2->5", "1->3"]
 */
public class p257 {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> result = new LinkedList<>();
        if (root == null) return result;
        String path = "";
        helper(root, result, path);
        return result;
    }

    private void helper(TreeNode root, List<String> result, String path) {
        path += root.val;
        if (root.left == null && root.right == null) {
            result.add(path);
        }
        path += "->";
        if (root.left != null)
            helper(root.left, result, path);
        if (root.right != null)
            helper(root.right, result, path);
    }

    public static void main(String[] args) {
        p257 sol = new p257();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.right = new TreeNode(5);
        root.right = new TreeNode(3);
        System.out.println(sol.binaryTreePaths(root));
    }
}
