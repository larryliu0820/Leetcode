import org.w3c.dom.Attr;

/**
 * Created by Valued Customer on 9/21/2016.
 * 333. Largest BST Subtree
 * Given a binary tree, find the largest subtree which is a Binary Search Tree (BST), where largest means subtree with largest number of nodes in it.

 Note:
 A subtree must include all of its descendants.
 Here's an example:
     10
    / \
   5  15
  / \   \
 1   8   7
 The Largest BST Subtree in this case is the highlighted one.
 The return value is the subtree's size, which is 3.
 */
public class p333 {
    class Attributes {
        Attributes() {min = 0; max = 0; size = 0;}
        int min;
        int max;
        int size;
        void set(int min, int max, int size) {
            this.min = min;
            this.max = max;
            this.size = size;
        }
    }
    public int largestBSTSubtree(TreeNode root) {
        if (root == null) return 0;
        Attributes res = new Attributes();
        isBST(root, res);
        return res.size;
    }

    private boolean isBST(TreeNode root, Attributes attr) {
        if (root.left == null && root.right == null) {
            attr.size = 1;
            attr.min = root.val;
            attr.max = root.val;
            return true;
        }
        boolean leftRes = false;
        Attributes leftAttr = new Attributes();
        if (root.left != null) leftRes = isBST(root.left, leftAttr);
        boolean rightRes = false;
        Attributes rightAttr = new Attributes();
        if (root.right != null) rightRes = isBST(root.right, rightAttr);

        if (rightRes && leftRes && leftAttr.max < root.val && root.val < rightAttr.min) {
            attr.set(leftAttr.min, rightAttr.max, leftAttr.size + rightAttr.size + 1);
            return true;
        } else if (rightRes && leftAttr.size == 0 && root.val < rightAttr.min){
            attr.set(root.val, rightAttr.max, rightAttr.size + 1);
            return true;
        } else if (leftRes && rightAttr.size == 0 && root.val > leftAttr.max) {
            attr.set(leftAttr.min, root.val, leftAttr.size + 1);
            return true;
        } else {
            attr.size = Math.max(leftAttr.size, rightAttr.size);
            return false;
        }
    }
}
