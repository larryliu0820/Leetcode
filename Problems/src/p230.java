import java.util.Stack;

/**
 * Created by Valued Customer on 10/08/2017.
 * 230. Kth Smallest Element in a BST
 * Given a binary search tree, write a function kthSmallest to find the kth smallest element in it.

 Note:
 You may assume k is always valid, 1 ≤ k ≤ BST's total elements.

 Follow up:
 What if the BST is modified (insert/delete operations) often and you need to find the kth smallest frequently? How would you optimize the kthSmallest routine?

 Show Hint

 */
public class p230 {

    public int kthSmallest(TreeNode root, int k) {
        Stack<TreeNode> stack = new Stack<>();
        pushLeft(stack, root);
        int i = 0;
        TreeNode curr = root;
        while (!stack.isEmpty()) {
            curr = stack.pop();
            i++;
            if (k == i) break;
            pushLeft(stack, curr.right);
        }
        return curr.val;
    }

    private void pushLeft(Stack<TreeNode> stack, TreeNode node) {
        while (node != null) {
            stack.push(node);
            node = node.left;
        }
    }
}
