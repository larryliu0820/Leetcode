import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

/**
 * Created by Larry Liu on 10/13/2017.
 * 449. Serialize and Deserialize BST
 */
public class p449 {

    private static final String SEP = ",";
    private static final String NULL = "#";

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        Stack<TreeNode> stack = new Stack<>();
        if (root == null) return "#";

        stack.push(root);
        while (!stack.isEmpty()) {
            root = stack.pop();
            sb.append(root.val).append(",");
            if (root.right != null) stack.push(root.right);
            if (root.left != null) stack.push(root.left);

        }

        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data.equals(NULL)) return null;
        String[] nums = data.split(SEP);
        Queue<Integer> q = new LinkedList<>();
        for (String num: nums) {
            q.offer(Integer.parseInt(num));
        }
        return getNode(q);
    }

    private TreeNode getNode(Queue<Integer> q) {
        if (q.isEmpty()) return null;
        TreeNode root = new TreeNode(q.poll());
        Queue<Integer> smallerQueue = new LinkedList<>();
        while (!q.isEmpty() && q.peek() < root.val) {
            smallerQueue.offer(q.poll());
        }
        root.left = getNode(smallerQueue);
        root.right = getNode(q);
        return root;
    }
}
