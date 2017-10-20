/**
 * Created by Larry Liu on 10/14/2017.
 * 450. Delete Node in a BST
 */
public class p450 {
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) return null;
        if (root.val < key) root.right = deleteNode(root.right, key);
        else if (root.val > key) root.left = deleteNode(root.left, key);
        else {
            if (root.left == null) return root.right;
            if (root.right == null) return root.left;
            // find the node that will replace root
            TreeNode oldRoot = root;
            root = root.right;
            while (root.left != null) root = root.left;
            root.right = deleteMin(oldRoot.right);
            root.left = oldRoot.left;
        }
        return root;
    }

    private TreeNode deleteMin(TreeNode node) {
        if (node.left == null) return node.right;
        node.left = deleteMin(node.left);
        return node;
    }

}
