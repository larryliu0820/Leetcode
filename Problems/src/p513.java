import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * Created by Valued Customer on 7/29/2017.
 * 513. Find Bottom Left Tree Value
 */
public class p513 {
    public int findBottomLeftValue(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        int[] size = new int[2];
        size[0] = 1;
        int ind = 0;
        q.offer(root);
        int result = root.val;
        while (!q.isEmpty()) {
            TreeNode curr = q.poll();
            if (curr.left != null) {
                q.offer(curr.left);
                size[(ind+1)%2]++;
            }
            if (curr.right != null) {
                q.offer(curr.right);
                size[(ind+1)%2]++;
            }
            size[ind]--;
            if (size[ind] == 0) {
                ind = (ind+1) %2;
                if (!q.isEmpty() && q.size() == size[ind]) result = q.peek().val;
            }
        }
        return result;
    }
}
