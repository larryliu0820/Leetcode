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
        int closest = root.val;
        TreeNode itr = root;
        while (itr!=null) {
            closest = Math.abs(itr.val - target) > Math.abs(closest-target)?closest:itr.val;
            if (itr.val > target) {
                itr = itr.left;
            } else {
                itr = itr.right;
            }
        }
        return closest;
    }
}
