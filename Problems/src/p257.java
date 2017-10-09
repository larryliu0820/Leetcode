import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/**
 * Created by Valued Customer on 10/08/2017.
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
        Set<String> res = new HashSet<>();
        if (root != null) helper(res, "", root);
        return new LinkedList<>(res);
    }

    private void helper(Set<String> res, String path, TreeNode node) {
        if (path.length() > 0) path += "->";
        path += node.val;
        if (node.left == null && node.right == null) {
            if (path.length() > 0 && !res.contains(path)) res.add(path);
            return;
        }
        if (node.left != null) helper(res, path, node.left);
        if (node.right != null) helper(res, path, node.right);
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
