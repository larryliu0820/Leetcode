/**
 * Created by Valued Customer on 7/4/2017.
 *
 * 236. Lowest Common Ancestor of a Binary Tree
 */
public class p236 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return null;
        if (root == p || root == q) return root;
        TreeNode leftRes = lowestCommonAncestor(root.left, p, q);
        TreeNode rightRes = lowestCommonAncestor(root.right, p, q);
        if (leftRes != null && rightRes != null) return root;
        return leftRes == null?rightRes:leftRes;
    }
}
