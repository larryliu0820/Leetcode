import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by Valued Customer on 8/5/2016.
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


    public List<TreeNode> generateTrees(int n) {
        List<TreeNode> result = generateTreesHelper(1, n);
        return result;
    }

    public List<TreeNode> generateTreesHelper(int begin, int end) {
        List<TreeNode> list = new ArrayList<>();
        if (begin == end) {
            list.add(new TreeNode(begin));
            return list;
        }
        if (begin > end) return list;
        for (int i = begin; i <= end; i++) {
            System.out.println("i = " + i);
            List<TreeNode> leftTrees;
            List<TreeNode> rightTrees;
            if (i != begin && i != end) {
                leftTrees = generateTreesHelper(begin, i-1);
                rightTrees = generateTreesHelper(i+1, end);
                for (TreeNode left : leftTrees) {
                    for (TreeNode right : rightTrees) {
                        TreeNode root = new TreeNode(i);
                        root.right = copyTreeNode(right);
                        root.left = copyTreeNode(left);
                        list.add(root);
                    }
                }
            } else if (i == begin) {
                rightTrees = generateTreesHelper(i+1, end);
                for (TreeNode right : rightTrees) {
                    TreeNode root = new TreeNode(i);
                    root.right = copyTreeNode(right);
                    list.add(root);
                }
            } else {
                leftTrees = generateTreesHelper(begin, i-1);
                for (TreeNode left : leftTrees) {
                    TreeNode root = new TreeNode(i);
                    root.left = copyTreeNode(left);
                    list.add(root);
                }
            }
        }
        return list;
    }

    public TreeNode copyTreeNode(TreeNode n) {
        if (n == null) return null;
        TreeNode copy = new TreeNode(n.val);
        copy.left = copyTreeNode(n.left);
        copy.right = copyTreeNode(n.right);
        return copy;
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
