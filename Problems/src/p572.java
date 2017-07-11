/**
 * Created by Valued Customer on 7/9/2017.
 *
 * 572. Subtree of Another Tree
 */
public class p572 {
    public boolean isSubtree(TreeNode s, TreeNode t) {
        if (s == null) return false;
        if (t == null) return true;
        return isSubtree(s.left, t) || isSubtree(s.right, t) || isSubtreeHelper(s, t);
    }

    private boolean isSubtreeHelper(TreeNode s, TreeNode t) {
        if (s == null && t == null) return true;
        if (s == null || t == null) return false;
        return (s.val == t.val) && isSubtreeHelper(s.left, t.left) && isSubtreeHelper(s.right, t.right);
    }
}
