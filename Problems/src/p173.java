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
    private Stack<TreeNode> stack = new Stack<>();
    public p173(TreeNode root) {
        pushAll(root);
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return !stack.isEmpty();
    }

    /** @return the next smallest number */
    public int next() {
        TreeNode itr = stack.pop();
        pushAll(itr.right);
        return itr.val;
    }

    public void pushAll(TreeNode node) {
        for (; node != null; node = node.left) {stack.push(node);}
    }
}
