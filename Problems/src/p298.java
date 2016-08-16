import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * Created by Valued Customer on 8/15/2016.
 * 298. Binary Tree Longest Consecutive Sequence
 * Given a binary tree, find the length of the longest consecutive sequence path.

 The path refers to any sequence of nodes from some starting node to any node in the tree along the parent-child connections.
 The longest consecutive path need to be from parent to child (cannot be the reverse).

 For example,
 1
  \
   3
  / \
 2   4
      \
       5
 Longest consecutive sequence path is 3-4-5, so return 3.
   2
    \
     3
    /
   2
  /
 1
 Longest consecutive sequence path is 2-3,not3-2-1, so return 2.
 */
public class p298 {
    private int max = 0;
    public int longestConsecutive(TreeNode root) {
        if (root == null) return 0;
        longestConsecutiveHelper(root, root.val, 0);
        return max;
    }

    public void longestConsecutiveHelper(TreeNode root, int last, int len) {
        if (root.val == last + 1) len++;
        else len = 1;
        max = Math.max(max, len);
        if (root.left != null) longestConsecutiveHelper(root.left, root.val, len);
        if (root.right != null) longestConsecutiveHelper(root.right, root.val, len);

    }

    public static void main(String[] args) {
        p298 sol = new p298();
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(2);
        root.right.right = new TreeNode(4);
        root.right.right.right = new TreeNode(5);
        System.out.println(sol.longestConsecutive(root));
    }
}
