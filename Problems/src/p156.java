/**
 * Created by Valued Customer on 8/9/2016.
 * 156. Binary Tree Upside Down
 * Given a binary tree where all the right nodes are either leaf nodes with a sibling (a left node that shares the same parent node) or empty,
 * flip it upside down and turn it into a tree where the original right nodes turned into left leaf nodes. Return the new root.

 For example:
 Given a binary tree {1,2,3,4,5},
     1
    / \
   2   3
  / \
 4   5
 return the root of the binary tree [4,5,2,#,#,3,1].
     4
    / \
   5   2
      / \
     3   1
 */
public class p156 {
    public TreeNode upsideDownBinaryTree(TreeNode root) {
        if (root == null) return null;
        TreeNode newRoot = root;
        while(newRoot.left != null) newRoot = newRoot.left;
        helper(root);
        return newRoot;
    }

    public TreeNode helper(TreeNode root) {
        if (root.left == null) return root;
        TreeNode oldLeft = root.left;
        TreeNode oldRight = root.right;
        root.left = null;
        root.right = null;
        TreeNode leftMost = helper(oldLeft);
        leftMost.left = oldRight;
        leftMost.right = root;
        return root;
    }
}
