import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by Valued Customer on 8/17/2016.
 * 173. Binary Search Tree Iterator
 * Implement an iterator over a binary search tree (BST). Your iterator will be initialized with the root node of a BST.

 Calling next() will return the next smallest number in the BST.

 Note: next() and hasNext() should run in average O(1) time and uses O(h) memory, where h is the height of the tree.
 */
public class p173 {
    Stack<TreeNode> stack;
    public p173(TreeNode root) {
        stack = new Stack<>();
        pushLeft(root);

    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return !stack.isEmpty();
    }

    /** @return the next smallest number */
    public int next() {
        TreeNode node = stack.pop();
        pushLeft(node.right);
        return node.val;
    }

    private void pushLeft(TreeNode root) {
        while (root != null) {
            stack.push(root);
            root = root.left;
        }
    }
}
