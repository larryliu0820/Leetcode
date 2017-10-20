import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * Created by Larry Liu on 10/11/2017.
 * 145. Binary Tree Postorder Traversal
 */
public class p145 {
    public List<Integer> postorderTraversal(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        List<Integer> res = new LinkedList<>();
        pushRight(root, stack, res);
        while (!stack.isEmpty()) {
            TreeNode curr = stack.pop();
            pushRight(curr.left, stack, res);
        }
        return res;
    }

    private void pushRight(TreeNode node, Stack<TreeNode> stack, List<Integer> res) {
        while (node != null) {
            res.add(0, node.val);
            stack.push(node);
            node = node.right;
        }
    }
}
