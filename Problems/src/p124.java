/**
 * Created by Valued Customer on 8/10/2017.
 * 124. Binary Tree Maximum Path Sum
 */
public class p124 {

    int max;
    public int maxPathSum(TreeNode root) {
        max = Integer.MIN_VALUE;
        helper(root);
        return max;
    }

    private int helper(TreeNode node) {
        if (node == null) return 0;
        int left = Math.max(0, helper(node.left));
        int right = Math.max(0, helper(node.right));
        max = Math.max(max, left + right + node.val);
        return Math.max(left, right) + node.val;
    }
}
