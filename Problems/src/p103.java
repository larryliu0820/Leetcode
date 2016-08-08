import sun.reflect.generics.tree.Tree;

import java.util.ArrayList;
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
        List<List<Integer>> results = new ArrayList<>();
        if (root == null) return results;

        List<TreeNode> list = new ArrayList<>();
        List<TreeNode> childList = new ArrayList<>();
        list.add(root);

        boolean leftToRight = true;

        List<Integer> result = new ArrayList<>();
        boolean needSwitch = false;
        while(!list.isEmpty() || !childList.isEmpty()) {
            TreeNode r = list.remove(0);
            result.add(r.val);
            if (list.isEmpty()) {
                results.add(result);
                result = new ArrayList<>();
                needSwitch = true;
            }
            if (leftToRight) {
                if (r.left != null) childList.add(0, r.left);
                if (r.right != null) childList.add(0, r.right);
            } else {
                if (r.right != null) childList.add(0, r.right);
                if (r.left != null) childList.add(0, r.left);
            }
            if (needSwitch) {
                leftToRight ^= true;
                List<TreeNode> temp = childList;
                childList = list;
                list = temp;
                needSwitch = false;
            }

        }
        return results;
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
