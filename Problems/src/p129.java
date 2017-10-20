import java.util.LinkedList;
import java.util.List;

/**
 * Created by Larry Liu on 10/13/2017.
 * 129. Sum Root to Leaf Numbers
 */
public class p129 {
    int height = 0;
    int numPath = 0;
    public int sumNumbers(TreeNode root) {
        List<Integer> list = new LinkedList<>();
        if (root == null) return 0;
        helper(root, 0, list);
        int sum = 0;
        for (int n: list) sum += n;
        return sum;

    }

    private void helper(TreeNode node, int curr, List<Integer> list) {
        if (node == null) return;
        curr = curr * 10 + node.val;

        if (node.left == null && node.right == null) {
            list.add(curr);
            return;
        }
        helper(node.left, curr, list);
        helper(node.right, curr, list);
    }

}
