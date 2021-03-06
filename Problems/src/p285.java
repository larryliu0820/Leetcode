import java.util.Stack;

/**
 * Created by Valued Customer on 7/29/2017.
 * 285. Inorder Successor in BST
 */
public class p285 {
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        Stack<TreeNode> stack = new Stack<>();
        pushLeft(stack, root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            pushLeft(stack, node.right);
            if (node == p) {
                return stack.isEmpty()?null:stack.peek();
            }

        }
        return null;
    }

    private void pushLeft(Stack<TreeNode> stack, TreeNode node) {
        while (node != null) {
            stack.push(node);
            node = node.left;
        }
    }
}
