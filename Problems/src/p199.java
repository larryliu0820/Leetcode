import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by Larry Liu on 10/8/2017.
 * 199. Binary Tree Right Side View
 */
public class p199 {
    public List<Integer> rightSideView(TreeNode root) {
        List<TreeNode> queue = new LinkedList<>();
        List<Integer> res = new LinkedList<>();
        if (root == null) return res;
        queue.add(root);

        while (queue.size() != 0) {
            res.add(queue.get(queue.size()-1).val);
            List<TreeNode> tempQ = new LinkedList<>();
            while (queue.size() != 0) {
                TreeNode curr = queue.remove(0);
                if (curr.left != null) tempQ.add(curr.left);
                if (curr.right != null) tempQ.add(curr.right);
            }
            queue = tempQ;
        }
        return res;
    }
}
