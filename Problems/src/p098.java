/**
 * Created by Valued Customer on 8/3/2017.
 * 98. Validate Binary Search Tree
 */
public class p098 {
    class Info {
        int min, max;
        Info(){}
    }
    public boolean isValidBST(TreeNode root) {
        if (root == null) return true;
        return helper(root, new Info());
    }

    private boolean helper(TreeNode root, Info info) {
        if (root.left == null && root.right == null) {
            info.max = root.val;
            info.min = root.val;
            return true;
        } else if (root.left != null && root.right == null) {
            Info leftInfo = new Info();
            if (helper(root.left, leftInfo) && leftInfo.max < root.val) {
                info.max = root.val;
                info.min = leftInfo.min;
                return true;
            }
            return false;
        } else if (root.left == null && root.right != null) {
            Info rightInfo = new Info();
            if (helper(root.right, rightInfo) && rightInfo.min > root.val) {
                info.max = rightInfo.max;
                info.min = root.val;
                return true;
            }
            return false;
        } else {
            Info leftInfo = new Info();
            Info rightInfo = new Info();
            if (helper(root.right, rightInfo) &&
                    rightInfo.min > root.val &&
                    helper(root.left, leftInfo) &&
                    leftInfo.max < root.val ) {
                info.max = rightInfo.max;
                info.min = leftInfo.min;
                return true;
            }
            return false;
        }

    }
}
