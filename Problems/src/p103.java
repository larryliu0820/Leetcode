import sun.reflect.generics.tree.Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Valued Customer on 8/7/2016.
 * 103. Binary Tree Zigzag Level Order Traversal
 * Given a binary tree, return the zigzag level order traversal of its nodes' values. (ie, from left to right, then right to left for the next level and alternate between).

 For example:
 Given binary tree [3,9,20,null,null,15,7],
 3
 / \
 9  20
 /  \
 15   7
 return its zigzag level order traversal as:
 [
 [3],
 [20,9],
 [15,7]
 ]
 */
public class p103 {

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new LinkedList<>();
        if (root == null) return result;
        boolean leftToRight = true;
        List<TreeNode> level = new LinkedList<>();
        List<TreeNode> nextLevel = new LinkedList<>();
        level.add(root);
        while (!level.isEmpty() || !nextLevel.isEmpty()) {
            List<Integer> levelRes = new LinkedList<>();
            while (!level.isEmpty()) {
                if (leftToRight) {
                    TreeNode itr = level.remove(0);
                    levelRes.add(itr.val);
                    if (itr.left != null) nextLevel.add(itr.left);
                    if (itr.right != null) nextLevel.add(itr.right);
                } else {
                    TreeNode itr = level.remove(level.size()-1);
                    levelRes.add(itr.val);
                    if (itr.right != null) nextLevel.add(0, itr.right);
                    if (itr.left != null) nextLevel.add(0, itr.left);
                }
            }
            leftToRight ^= true;
            List<TreeNode> temp = level;
            level = nextLevel;
            nextLevel = temp;
            result.add(levelRes);
        }
        return result;
    }
    public static void main(String[] args) {
        p103 sol = new p103();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.right.right = new TreeNode(5);
        List<List<Integer>> result = sol.zigzagLevelOrder(root);
        System.out.println("[");
        for(List<Integer> r : result) {
            System.out.println(r.toString());
        }
        System.out.println("]");
    }
}
