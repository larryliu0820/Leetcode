/**
 * Created by Valued Customer on 8/29/2016.
 * 270. Closest Binary Search Tree Value
 * Given a non-empty binary search tree and a target value, find the value in the BST that is closest to the target.

 Note:
 Given target value is a floating point.
 You are guaranteed to have only one unique value in the BST that is closest to the target.
 */
public class p270 {

    public int closestValue(TreeNode root, double target) {
        int mid = root.val;
        if (target > mid) {
            if (root.right != null) {
                int rightResult = closestValue(root.right, target);
                return Math.abs(rightResult - target) > Math.abs(mid - target) ? mid: rightResult;
            }
        } else {
            if (root.left != null) {
                int leftResult = closestValue(root.left, target);
                return Math.abs(leftResult - target) > Math.abs(mid - target) ? mid: leftResult;
            }
        }
        return mid;
    }
}
