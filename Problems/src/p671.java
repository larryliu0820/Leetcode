/**
 * Created by Larry Liu on 10/16/2017.
 * 671. Second Minimum Node In a Binary Tree
 */
public class p671 {

    public int findSecondMinimumValue(TreeNode root) {
        TreeNode left = root.left, right = root.right;
        if (left != null && right != null) {
            int nextRes = -1;
            if (left.val < right.val) {
                nextRes = findSecondMinimumValue(left);
                if (nextRes == -1) return right.val;
                else return Math.min(nextRes, right.val);
            } else if (left.val > right.val) {
                nextRes = findSecondMinimumValue(right);
                if (nextRes == -1) return left.val;
                else return Math.min(nextRes, left.val);
            } else {
                int leftRes = findSecondMinimumValue(left);
                int rightRes = findSecondMinimumValue(right);
                if (leftRes == -1 || rightRes == -1) {
                    return Math.max(leftRes, rightRes);
                } else {
                    return Math.min(leftRes, rightRes);
                }
            }

        } else return -1;
    }
}
