import java.util.LinkedList;
import java.util.List;

/**
 * Created by Larry Liu on 10/16/2017.
 * 366. Find Leaves of Binary Tree
 */
public class p366 {
    public List<List<Integer>> findLeaves(TreeNode root) {
        List<List<Integer>> res = new LinkedList<>();
        helper(res, root);
        return res;
    }

    private int helper(List<List<Integer>> res, TreeNode node) {
        if (node == null) return 0;
        if (node.left == null && node.right == null) {
            if (res.size() == 0) res.add(new LinkedList<>());
            res.get(0).add(node.val);
            return 1;
        }
        int leftLevel = helper(res, node.left);
        int rightLevel = helper(res, node.right);

        int currLevel = Math.max(leftLevel, rightLevel);
        if (res.size() <= currLevel) res.add(currLevel, new LinkedList<>());
        res.get(currLevel).add(node.val);

        return currLevel + 1;
    }
}
