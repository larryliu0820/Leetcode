import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * Created by Valued Customer on 8/8/2017.
 * 94. Binary Tree Inorder Traversal
 */
public class p094 {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new LinkedList<>();
        Stack<TreeNode> stack = new Stack<>();
        pushLeft(stack, root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            pushLeft(stack, node.right);
            result.add(node.val);
        }
        return result;
    }

    private void pushLeft(Stack<TreeNode> stack, TreeNode node) {
        while (node != null) {
            stack.push(node);
            node = node.left;
        }
    }
}
