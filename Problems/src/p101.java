/**
 * Created by Valued Customer on 8/8/2017.
 * 101. Symmetric Tree
 */
public class p101 {
    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        return helper(root.left, root.right);
    }

    private boolean helper(TreeNode n1, TreeNode n2) {
        if (n1 == null && n2 == null) return true;
        else if (n1 == null || n2 == null) return false;
        if (!helper(n1.left, n2.right)) return false;
        if (!helper(n1.right, n2.left)) return false;
        return n1.val == n2.val;
    }
}
