/**
 * Created by Larry Liu on 10/7/2017.
 * 99. Recover Binary Search Tree
 */
public class p099 {
    TreeNode first = null, second = null, prev = new TreeNode(Integer.MIN_VALUE);
    public void recoverTree(TreeNode root) {
        inorder(root);

        int temp = first.val;
        first.val = second.val;
        second.val = temp;

    }

    private void inorder(TreeNode node) {
        if (node == null) return;
        inorder(node.left);
        if (prev.val > node.val) {
            if (first == null) first = prev;
            second = node;
        }
        prev = node;
        inorder(node.right);
    }
}
