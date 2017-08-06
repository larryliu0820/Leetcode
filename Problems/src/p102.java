import java.time.temporal.Temporal;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by Valued Customer on 8/5/2017.
 * 102. Binary Tree Level Order Traversal
 */
public class p102 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new LinkedList<>();
        Queue<TreeNode> q = new LinkedList<>();
        Queue<TreeNode> nextQ = new LinkedList<>();
        if (root != null) q.offer(root);
        while (!q.isEmpty()) {
            List<Integer> level = new LinkedList<>();
            while (!q.isEmpty()) {
                TreeNode itr = q.poll();
                if (itr.left != null) nextQ.offer(itr.left);
                if (itr.right != null) nextQ.offer(itr.right);
                level.add(itr.val);
            }

            result.add(level);

            Queue<TreeNode> temp = q;
            q = nextQ;
            nextQ = temp;

        }
        return result;
    }

}
