import sun.reflect.generics.tree.Tree;

import java.util.*;

/**
 * Created by Valued Customer on 10/10/2017.
 * 95. Unique Binary Search Trees II
 * Given an integer n, generate all structurally unique BST's (binary search trees) that store values 1...n.

 For example,
 Given n = 3, your program should return all 5 unique BST's shown below.

 1         3     3      2      1
 \       /     /      / \      \
 3     2     1      1   3      2
 /     /       \                 \
 2     1         2                 3
 */

public class p095 {
    Map<Integer, List<TreeNode>> map;
    public List<TreeNode> generateTrees(int n) {
        return genTrees(1, n);
    }
    public List<TreeNode> genTrees(int start, int end) {
        if (map == null) map = new HashMap<>();
        List<TreeNode> res = new LinkedList<>();
        if (end < start) {
            res.add(null);
            return res;
        }
        for (int i = start; i <= end; i++) {
            List<TreeNode> leftRes = genTrees(start, i-1);
            List<TreeNode> rightRes = genTrees(i+1, end);
            for (TreeNode l: leftRes) {
                for (TreeNode r: rightRes) {
                    TreeNode n = new TreeNode(i);
                    n.left = l;
                    n.right = r;
                    res.add(n);
                }
            }
        }
        return res;
    }

    public void printTree(TreeNode node) {
        System.out.print(node.val + ",");
        if (node.left == null && node.right == null) return;
        if (node.left != null)
            printTree(node.left);
        else
            System.out.print("null,");
        if (node.right != null)
            printTree(node.right);
        else
            System.out.print("null,");
    }
    public static void main(String[] args) {
        p095 sol = new p095();
        List<TreeNode> result = sol.generateTrees(3);
        System.out.println("[");
        Iterator<TreeNode> itr = result.iterator();
        while (itr.hasNext()) {
            TreeNode node = itr.next();
            System.out.print("[");
            sol.printTree(node);
            System.out.print("]\n");
        }
        System.out.println("]");
    }

}
