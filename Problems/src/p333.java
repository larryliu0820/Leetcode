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
    class Result {
        int max, min;
        boolean isBST;
        public Result() {
            max = 0;
            min = 0;
            isBST = false;
        }
        public void set(int a, int i, boolean b) {
            max = a;
            min = i;
            isBST = b;
        }
    }
    int maxSize;
    public int largestBSTSubtree(TreeNode root) {
        helper(root, new Result());
        return maxSize;
    }

    private int helper(TreeNode node, Result res) {
        if (node == null) {
            res.set(Integer.MIN_VALUE, Integer.MAX_VALUE, true);
            return 0;
        }
        Result leftRes = new Result();
        Result rightRes = new Result();

        int leftSize = helper(node.left, leftRes);
        int rightSize = helper(node.right, rightRes);

        if (leftRes.isBST && node.val > leftRes.max && rightRes.isBST && node.val < rightRes.min) {
            res.set(rightRes.max>node.val?rightRes.max:node.val, leftRes.min<node.val?leftRes.min:node.val, true);
            int size = leftSize + rightSize + 1;
            maxSize = Math.max(size, maxSize);
            return size;
        }

        return 0;

    }
}
