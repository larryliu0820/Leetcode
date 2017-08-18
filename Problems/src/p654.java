import java.util.*;

/**
 * Created by Valued Customer on 8/14/2017.
 * 654. Maximum Binary Tree
 */
public class p654 {
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        if (nums == null || nums.length == 0) return null;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(new TreeNode(nums[0]));
        for (int i = 1; i < nums.length; i++) {
            TreeNode curr = new TreeNode(nums[i]);
            TreeNode last = stack.peek();
            while (!stack.isEmpty() && stack.peek().val < nums[i]) {
                last = stack.pop();
            }
            if (!stack.isEmpty()) last = stack.peek();
            if (last.val < nums[i]) {
                curr.left = last;
            } else {
                TreeNode right = last.right;
                last.right = curr;
                curr.left = right;
            }
            stack.push(curr);

        }
        return stack.firstElement();

    }


}
