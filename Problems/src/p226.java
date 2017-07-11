/**
 * Created by Valued Customer on 7/6/2017.
 *
 * 226. Invert Binary Tree
 */
public class p226 {
    public TreeNode invertTree(TreeNode root) {
        if (root == null) return null;
        TreeNode oldLeft = root.left;
        TreeNode oldRight = root.right;
        root.left = invertTree(oldRight);
        root.right = invertTree(oldLeft);
        return root;
    }
}
