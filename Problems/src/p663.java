import java.util.HashMap;
import java.util.Map;

/**
 * Created by Larry Liu on 10/18/2017.
 * 663. Equal Tree Partition
 */
public class p663 {
    public boolean checkEqualTree(TreeNode root) {
        Map<TreeNode, Integer> map = new HashMap<>();
        helper(map, root);
        for (TreeNode key: map.keySet())
            if (key != root && map.get(key) * 2 == map.get(root)) return true;
        return false;
    }

    private void helper(Map<TreeNode, Integer> map, TreeNode node) {
        if (node == null) return;
        int leftSum = 0, rightSum = 0;
        if (node.left != null) {
            helper(map, node.left);
            leftSum = map.get(node.left);
        }
        if (node.right != null) {
            helper(map, node.right);
            rightSum = map.get(node.right);
        }
        map.put(node, node.val + leftSum + rightSum);

    }
}
