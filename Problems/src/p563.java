/**
 * Created by Larry Liu on 10/15/2017.
 * 563. Binary Tree Tilt
 */
public class p563 {
    int sum = 0;
    public int findTilt(TreeNode root) {
        if (root == null) {
            sum = 0;
            return 0;
        }
        int leftTilt = findTilt(root.left);
        int leftSum = sum;
        int rightTilt = findTilt(root.right);
        int rightSum = sum;
        sum = leftSum + rightSum + root.val;
        return leftTilt + rightTilt + Math.abs(leftSum - rightSum);
    }
}
