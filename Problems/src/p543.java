/**
 * Created by Valued Customer on 7/9/2017.
 *
 * 543. Diameter of Binary Tree
 */
public class p543 {
    class Height
    {
        int h;
    }

    public int diameterOfBinaryTree(TreeNode root) {
        Height h = new Height();
        return diameter(root, h);

    }

    private int diameter(TreeNode root, Height h) {
        if (root == null) return 0;
        int leftDiameter = 0, leftHeight = 0, rightDiameter = 0, rightHeight = 0, tempDiameter = 0;
        if (root.left != null) {
            Height leftHeightObj = new Height();
            leftDiameter = diameter(root.left, leftHeightObj);
            leftHeight = leftHeightObj.h;
            tempDiameter++;
        }
        if (root.right != null) {
            Height rightHeightObj = new Height();
            rightDiameter = diameter(root.right, rightHeightObj);
            rightHeight = rightHeightObj.h;
            tempDiameter++;
        }

        tempDiameter += leftHeight + rightHeight;
        h.h = Math.max(leftHeight, rightHeight) + 1;

        return Math.max(Math.max(leftDiameter, rightDiameter), tempDiameter);
    }

}
