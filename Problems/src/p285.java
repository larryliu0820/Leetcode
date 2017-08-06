import java.util.Stack;

/**
 * Created by Valued Customer on 7/29/2017.
 * 285. Inorder Successor in BST
 */
public class p285 {
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        Stack<TreeNode> stack = new Stack<>();
        if (root == null) return null;
        pushLeft(stack, root);
        while (!stack.isEmpty()) {
            TreeNode curr = stack.pop();
            if (curr.right != null) pushLeft(stack, curr.right);
            if (curr.val == p.val) {
                return stack.isEmpty()?null:stack.peek();
            }
        }
        return null;
    }
    private void pushLeft(Stack<TreeNode> stack, TreeNode t) {
        TreeNode itr = t;
        while (itr != null) {
            stack.push(itr);
            itr = itr.left;
        }

    }
}
