import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * Created by Larry Liu on 10/15/2017.
 * 652. Find Duplicate Subtrees
 */
public class p652 {
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        List<TreeNode> res = new LinkedList<>();
        preorder(root, new HashMap<>(), res);
        return res;
    }

    public String preorder(TreeNode cur, Map<String, Integer> map, List<TreeNode> res) {
        if (cur == null) return "#";
        String serial = cur.val + "," + preorder(cur.left, map, res) + "," + preorder(cur.right, map, res);
        if (map.getOrDefault(serial, 0) == 1) res.add(cur);
        map.put(serial, map.getOrDefault(serial, 0) + 1);
        return serial;
    }
}
