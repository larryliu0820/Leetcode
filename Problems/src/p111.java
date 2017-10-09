import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by Larry Liu on 10/8/2017.
 * 111. Minimum Depth of Binary Tree
 */
public class p111 {

    public int minDepth(TreeNode root) {
        int depth = 0;

        Queue<TreeNode> q = new LinkedList<>();
        if (root != null) q.offer(root);
        while (q.size() != 0) {
            depth++;
            Queue<TreeNode> tempQ = new LinkedList<>();
            while (q.size() != 0) {
                TreeNode curr = q.poll();
                if (curr.left == null && curr.right == null) return depth;
                if (curr.left != null) tempQ.offer(curr.left);
                if (curr.right != null) tempQ.offer(curr.right);
            }
            q = tempQ;
        }
        return depth;
    }
}
