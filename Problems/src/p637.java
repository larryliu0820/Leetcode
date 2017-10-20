import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by Larry Liu on 10/15/2017.
 * 637. Average of Levels in Binary Tree
 */
public class p637 {
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> res = new LinkedList<>();
        if (root == null) return res;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while (!q.isEmpty()) {
            Queue<TreeNode> level = new LinkedList<>();
            double avg = 0;
            int size = q.size();
            while (!q.isEmpty()) {
                TreeNode curr = q.poll();
                avg += (double) curr.val / (double) size;
                if (curr.left != null) level.offer(curr.left);
                if (curr.right != null) level.offer(curr.right);
            }
            res.add(avg);
            q = level;
        }
        return res;
    }
}
