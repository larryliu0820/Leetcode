import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Valued Customer on 7/17/2017.
 * 337. House Robber III
 *
 *
 */
public class p337 {
    List<Map<TreeNode, Integer>> dp;
    public int rob(TreeNode root) {
        dp = new ArrayList<>();
        dp.add(new HashMap<>());
        dp.add(new HashMap<>());
        return robHelper2(root, 1);
    }


    private int robHelper2(TreeNode root, int robThis) {
        if (root == null) return 0;
        if (!dp.get(robThis).containsKey(root)) {
            int robNextCount = robHelper2(root.left, 1) + robHelper2(root.right, 1);
            dp.get(0).put(root, robNextCount);
            if (robThis == 1) {
                int robThisCount = root.val + robHelper2(root.left, 0) + robHelper2(root.right, 0);
                dp.get(1).put(root, Math.max(robNextCount, robThisCount));
            }
        }
        return dp.get(robThis).get(root);
    }
    private int robHelper(TreeNode root, boolean robThis) {
        if (root == null) return 0;
        int count = robHelper(root.left, true) + robHelper(root.right, true);
        if (robThis) {
            return Math.max(count,
                    root.val + robHelper(root.left, false) + robHelper(root.right, false));
        } else {
            return count;
        }
    }
}
