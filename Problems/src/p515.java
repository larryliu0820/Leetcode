import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by Larry Liu on 10/16/2017.
 * 515. Find Largest Value in Each Tree Row
 */
public class p515 {
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> res = new LinkedList<>();
        if (root == null) return res;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while (!q.isEmpty()) {
            Queue<TreeNode> level = new LinkedList<>();
            int max = Integer.MIN_VALUE;
            while (!q.isEmpty()) {
                TreeNode curr = q.poll();
                if (curr.left != null) level.offer(curr.left);
                if (curr.right != null) level.offer(curr.right);
                max = Math.max(max, curr.val);
            }
            q = level;
            res.add(max);
        }
        return res;
    }
}
