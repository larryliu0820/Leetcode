import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by Larry Liu on 10/18/2017.
 * 623. Add One Row to Tree
 */
public class p623 {
    public TreeNode addOneRow(TreeNode root, int v, int d) {
        if (d == 1) {
            TreeNode curr = new TreeNode(v);
            curr.left = root;
            return curr;
        }
        List<TreeNode> q = new LinkedList<>();
        q.add(root);
        while (d > 1) {
            d--;
            List<TreeNode> level = new LinkedList<>();
            for (TreeNode curr: q) {
                if (curr.left != null) level.add(curr.left);
                if (curr.right != null) level.add(curr.right);
            }
            if (d > 1) q = level;
        }
        for (TreeNode itr: q) {
            TreeNode origLeft = itr.left;
            itr.left = new TreeNode(v);

            itr.left.left = origLeft;
            TreeNode origRight = itr.right;
            itr.right = new TreeNode(v);

            itr.right.right = origRight;
        }
        return root;
    }
}
