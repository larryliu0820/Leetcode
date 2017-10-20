/**
 * Created by Larry Liu on 10/17/2017.
 * 687. Longest Univalue Path
 */
public class p687 {
    int max = 0;
    public int longestUnivaluePath(TreeNode root) {
        helper(root);
        return max;
    }
    private int helper(TreeNode node) {
        if (node == null) return 0;
        int res = 0;
        int leftRes = helper(node.left);
        if (node.left != null && node.left.val == node.val) {
            max = Math.max(max, ++leftRes);
            res = leftRes;
        }
        int rightRes = helper(node.right);
        if (node.right != null && node.right.val == node.val) {
            max = Math.max(max, ++rightRes);
            res = rightRes;
        }
        if (node.left != null && node.right != null &&
                node.left.val == node.right.val && node.val == node.right.val) {
            max = Math.max(max, leftRes + rightRes);
            res = Math.max(leftRes, rightRes);
        }
        return res;
    }
}
