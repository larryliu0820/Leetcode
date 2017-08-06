import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by Valued Customer on 7/26/2017.
 * 297. Serialize and Deserialize Binary Tree
 */
public class p297 {
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        if (root != null) q.offer(root);
        StringBuilder sb = new StringBuilder();
        while (!q.isEmpty()) {
            TreeNode t = q.poll();
            if (sb.length() != 0) sb.append(",");
            if (t == null) {
                sb.append("null");
                continue;
            } else sb.append(t.val);
            q.offer(t.left);
            q.offer(t.right);
        }
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data.length() == 0) return null;
        String[] dataStr = data.split(",");
        Queue<TreeNode> q = new LinkedList<>();
        TreeNode head = null;
        if (dataStr.length > 0 && !dataStr[0].equals("null")) {
            head = new TreeNode(Integer.parseInt(dataStr[0]));
            q.offer(head);
        }
        int index = 1;
        while (!q.isEmpty()) {
            TreeNode t = q.poll();
            if (!dataStr[index].equals("null")) {
                t.left = new TreeNode(Integer.parseInt(dataStr[index]));
                q.offer(t.left);
            }
            index++;
            if (!dataStr[index].equals("null")) {
                t.right = new TreeNode(Integer.parseInt(dataStr[index]));
                q.offer(t.right);
            }
            index++;
        }
        return head;
    }
}
