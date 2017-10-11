import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * Created by Larry Liu on 10/10/2017.
 * 144. Binary Tree Preorder Traversal
 */
public class p144 {
    public List<Integer> preorderTraversal(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        List<Integer> res = new LinkedList<>();
        if (root == null) return res;
        pushLeft(root, stack, res);
        while (!stack.isEmpty()) {
            TreeNode curr = stack.pop();
            pushLeft(curr.right, stack, res);
        }
        return res;
    }

    private void pushLeft(TreeNode node, Stack<TreeNode> stack, List<Integer> res) {
        while (node != null) {
            res.add(node.val);
            stack.push(node);
            node = node.left;
        }
    }
}
