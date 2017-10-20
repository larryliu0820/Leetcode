import java.util.Stack;

/**
 * Created by Larry Liu on 10/15/2017.
 * 653. Two Sum IV - Input is a BST
 */
public class p653 {

    enum Direction {
        LEFT,
        RIGHT
    }
    public boolean findTarget(TreeNode root, int k) {
        Stack<TreeNode> preStack = new Stack<>();
        Stack<TreeNode> postStack = new Stack<>();
        pushDirection(root, preStack, Direction.LEFT);
        pushDirection(root, postStack, Direction.RIGHT);
        TreeNode forward = preStack.pop();
        TreeNode backward = postStack.pop();
        int sum;
        while (forward != backward) {
            sum = forward.val + backward.val;
            if (sum == k) return true;
            else if (sum < k) {
                pushDirection(forward.right, preStack, Direction.LEFT);
                forward = preStack.pop();
            } else {
                pushDirection(backward.left, postStack, Direction.RIGHT);
                backward = postStack.pop();
            }
        }
        return false;
    }

    private void pushDirection(TreeNode node, Stack<TreeNode> stack, Direction dir) {
        while (node != null) {
            stack.push(node);
            if (dir == Direction.LEFT) node = node.left;
            else node = node.right;
        }
    }


}
