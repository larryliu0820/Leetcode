import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by Valued Customer on 7/26/2017.
 * 297. Serialize and Deserialize Binary Tree
 */
public class p297 {
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        Queue<TreeNode> q = new LinkedList<>();
        Queue<TreeNode> nq = new LinkedList<>();
        q.offer(root);
        while (!q.isEmpty()) {
            while (!q.isEmpty()) {
                TreeNode itr = q.poll();
                if (itr == null) {
                    sb.append("null");
                } else {
                    if (sb.length() != 0)
                        sb.append(',');
                    sb.append(itr.val);
                    nq.offer(itr.left);
                    nq.offer(itr.right);
                }
            }
            Queue<TreeNode> tmp = q;
            q = nq;
            nq = tmp;
        }
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] nodes = data.split(",");
        Queue<TreeNode> q = new LinkedList<>();
        Queue<TreeNode> nq = new LinkedList<>();
        if (nodes[0].equals("null")) return null;
        TreeNode root = new TreeNode(Integer.parseInt(nodes[0]));
        q.offer(root);
        int index = 1;
        while (!q.isEmpty()) {
            while (!q.isEmpty()) {
                TreeNode itr = q.poll();
                if (!nodes[index].equals("null")) {
                    itr.left = new TreeNode(Integer.parseInt(nodes[index]));
                    nq.offer(itr.left);
                }
                index++;
                if (!nodes[index].equals("null")) {
                    itr.right = new TreeNode(Integer.parseInt(nodes[index]));
                    nq.offer(itr.right);
                }
                index++;
            }
            Queue<TreeNode> tmp = q;
            q = nq;
            nq = tmp;
        }
        return root;
    }
}
