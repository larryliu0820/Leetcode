import java.util.Stack;

/**
 * Created by Valued Customer on 8/19/2016.
 * 230. Kth Smallest Element in a BST
 * Given a binary search tree, write a function kthSmallest to find the kth smallest element in it.

 Note:
 You may assume k is always valid, 1 ≤ k ≤ BST's total elements.

 Follow up:
 What if the BST is modified (insert/delete operations) often and you need to find the kth smallest frequently? How would you optimize the kthSmallest routine?

 Show Hint

 */
public class p230 {

    private Stack<TreeNode> stack = new Stack<>();
    public int kthSmallest(TreeNode root, int k) {
        int num = 0;
        TreeNode curr = root;
        pushAll(curr);
        while (!stack.isEmpty()) {
            curr = stack.pop();
            num++;
            if (num == k) break;
            pushAll(curr.right);
        }
        return curr.val;
    }

    private void pushAll(TreeNode root) {
        for (; root != null; root = root.left) stack.push(root);
    }
}
