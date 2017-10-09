import java.util.HashMap;
import java.util.Map;

/**
 * Created by Larry Liu on 10/6/2017.
 * 105. Construct Binary Tree from Preorder and Inorder Traversal
 */
public class p105 {
    Map<Integer, Integer> map;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) map.put(inorder[i], i);
        return helper(preorder, 0, preorder.length-1, inorder, 0, inorder.length-1);
    }

    private TreeNode helper(int[] preorder, int pbegin, int pend, int[] inorder, int ibegin, int iend) {
        if (pbegin > pend) return null;
        TreeNode root = new TreeNode(preorder[pbegin]);
        int leftSize = map.get(preorder[pbegin]) - ibegin;
        int rightSize = iend - map.get(preorder[pbegin]);
        root.left = helper(preorder, pbegin + 1, pbegin + leftSize, inorder, ibegin, map.get(preorder[pbegin])-1);
        root.right = helper(preorder, pend - rightSize + 1, pend, inorder, map.get(preorder[pbegin]) + 1, iend);
        return root;
    }
}
