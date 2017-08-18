import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * Created by Valued Customer on 7/29/2017.
 * 513. Find Bottom Left Tree Value
 */
public class p513 {
    public int findBottomLeftValue(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            root = queue.poll();
            if (root.right != null)
                queue.add(root.right);
            if (root.left != null)
                queue.add(root.left);
        }
        return root.val;
    }
}
