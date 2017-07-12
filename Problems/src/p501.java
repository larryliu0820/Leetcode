import java.util.ArrayList;
import java.util.List;

/**
 * Created by larryliu on 7/11/17.
 *
 * 501. Find Mode in Binary Search Tree
 *
 * Given a binary search tree (BST) with duplicates, find all the mode(s) (the most frequently occurred element) in the given BST.

 Assume a BST is defined as follows:

 The left subtree of a node contains only nodes with keys less than or equal to the node's key.
 The right subtree of a node contains only nodes with keys greater than or equal to the node's key.
 Both the left and right subtrees must also be binary search trees.
 For example:
 Given BST [1,null,2,2],
  1
   \
   2
  /
 2
 return [2].

 Note: If a tree has more than one mode, you can return them in any order.

 Follow up: Could you do that without using any extra space? (Assume that the implicit stack space incurred due to recursion does not count).


 */
public class p501 {
    int maxCount = 1;
    int lastVal = 0;
    int count = 0;
    List<Integer> result = new ArrayList<>();
    public int[] findMode(TreeNode root) {
        findHelper(root);
        int[] ret = new int[result.size()];
        for (int i = 0; i < ret.length; i++) ret[i] = result.get(i);
        return ret;

    }

    private void findHelper(TreeNode root) {
        if (root == null) return;
        findHelper(root.left);
        if (lastVal == root.val || count == 0) count++;
        else count = 1;
        lastVal = root.val;
        if (maxCount == count) {
            result.add(lastVal);
        } else if (maxCount < count) {
            result = new ArrayList<>();
            result.add(lastVal);
            maxCount = count;
        }
        findHelper(root.right);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(2);
        p501 sol = new p501();
        sol.findMode(root);
    }
}
