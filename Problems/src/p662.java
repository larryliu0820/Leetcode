import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

/**
 * Created by Larry Liu on 10/16/2017.
 * 662. Maximum Width of Binary Tree
 */
public class p662 {
    public int widthOfBinaryTree(TreeNode root) {
        if (root == null) return 0;
        Map<TreeNode, Integer> map = new HashMap<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        map.put(root, 0);
        int width = 1;
        while (!q.isEmpty()) {
            Queue<TreeNode> level = new LinkedList<>();
            int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
            while (!q.isEmpty()) {
                TreeNode curr = q.poll();
                int ind = map.get(curr);
                min = Math.min(min, ind);
                max = Math.max(max, ind);
                if (curr.left != null) {
                    map.put(curr.left, ind * 2);
                    level.offer(curr.left);
                }
                if (curr.right != null) {
                    map.put(curr.right, ind * 2 + 1);
                    level.offer(curr.right);
                }
            }
            width = Math.max(width, max - min + 1);
            q = level;
        }
        return width;
    }
}
