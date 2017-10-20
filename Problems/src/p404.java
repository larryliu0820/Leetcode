import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * Created by Larry Liu on 10/14/2017.
 * 404. Sum of Left Leaves
 */
public class p404 {
    public int sumOfLeftLeaves(TreeNode root) {
        if (root == null) return 0;
        TreeNode left = root.left;
        int res = 0;
        if (left != null) {
            if (left.left == null && left.right == null) res = left.val;
            res += sumOfLeftLeaves(left);
        }
        res += sumOfLeftLeaves(root.right);
        return res;
    }

}
