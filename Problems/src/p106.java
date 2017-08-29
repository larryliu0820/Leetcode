import sun.reflect.generics.tree.Tree;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by mengwliu on 8/6/17.
 * 106. Construct Binary Tree from Inorder and Postorder Traversal
 */


public class p106 {
    int[] inorder, postorder;
    Map<Integer, Integer> map;
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder.length == 0) return null;
        this.inorder = inorder;
        this.postorder = postorder;
        map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) map.put(inorder[i], i);
        return buildHelper(0, inorder.length-1, 0, postorder.length-1);
    }

    private TreeNode buildHelper(int is, int ie, int ps, int pe) {
        if (is > ie || ps > pe) return null;
        int rootVal = postorder[pe];
        TreeNode root = new TreeNode(rootVal);
        int rootInd = map.get(rootVal);
        root.left = buildHelper(is, rootInd - 1, ps, ps+rootInd-is-1);
        root.right = buildHelper(rootInd + 1, ie, ps+rootInd-is, pe-1);
        return root;
    }
}
