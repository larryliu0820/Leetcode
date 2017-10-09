/**
 * Created by Larry Liu on 10/6/2017.
 * 110. Balanced Binary Tree
 */
public class p110 {
    int height;
    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            height = 0;
            return true;
        }
        if (!isBalanced(root.left)) return false;
        int leftHeight = height;
        if (!isBalanced(root.right)) return false;
        int rightHeight = height;
        height = Math.max(leftHeight, rightHeight) + 1;
        return (Math.abs(leftHeight - rightHeight) <= 1);
    }

}
