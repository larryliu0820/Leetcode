import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by Larry Liu on 10/11/2017.
 * 107. Binary Tree Level Order Traversal II
 */
public class p107 {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> result = new LinkedList<>();
        if (root == null) return result;
        Queue<TreeNode> level = new LinkedList<>();
        level.offer(root);
        while (!level.isEmpty()) {
            Queue<TreeNode> temp = new LinkedList<>();
            List<Integer> levelRes = new LinkedList<>();
            while (!level.isEmpty()) {
                TreeNode node = level.poll();
                if (node.left != null) temp.offer(node.left);
                if (node.right != null) temp.offer(node.right);
                levelRes.add(node.val);
            }
            level = temp;
            result.add(0, levelRes);
        }
        return result;
    }
}
