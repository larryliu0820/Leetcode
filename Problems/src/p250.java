/**
 * Created by Larry Liu on 10/11/2017.
 * 250. Count Univalue Subtrees
 */
public class p250 {
    public int countUnivalSubtrees(TreeNode root) {
        if (root == null) return 0;
        countHelper(root);
        return count;
    }

    int count;
    int value;
    private boolean countHelper(TreeNode node) {
        if (node.left == null && node.right == null) {
            value = node.val;
            count++;
            return true;
        }
        boolean leftRes = true;
        int leftVal = value;
        if (node.left != null) {
            leftRes = countHelper(node.left);
            leftVal = value;
        }

        boolean rightRes = true;
        int rightVal = value;
        if (node.right != null) {
            rightRes = countHelper(node.right);
            rightVal = value;
        }

        if (leftRes && rightRes && leftVal == node.val && rightVal == node.val) {
            value = node.val;
            count++;
            return true;
        } else {
            return false;
        }

    }
}
