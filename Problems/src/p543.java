/**
 * Created by Valued Customer on 10/12/2017.
 *
 * 543. Diameter of Binary Tree
 */
public class p543 {
    int maxLen = 0;
    int height = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null) return 0;
        diameter(root);
        return maxLen;
    }
    private void diameter(TreeNode node) {
        if (node.left == null && node.right == null) {
            maxLen = 0;
            height = 0;
            return;
        }
        int leftMax = 0, leftHeight = 0, inc = 0;
        if (node.left != null) {
            diameter(node.left);
            leftMax = maxLen;
            leftHeight = height;
            inc++;
        }

        int rightMax = 0, rightHeight = 0;
        if (node.right != null) {
            diameter(node.right);
            rightMax = maxLen;
            rightHeight = height;
            inc++;
        }

        maxLen = Math.max(leftMax, rightMax);
        maxLen = Math.max(maxLen, leftHeight + rightHeight + inc);
        height = Math.max(leftHeight, rightHeight) + 1;
    }
}
