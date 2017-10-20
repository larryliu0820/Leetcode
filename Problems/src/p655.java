import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Larry Liu on 10/15/2017.
 * 655. Print Binary Tree
 */
public class p655 {
    public List<List<String>> printTree(TreeNode root) {
        int height = getHeight(root);
        int len = (1 << height) - 1;
        String[][] res = new String[height][len];
        helper(root, res, 0, 0, len-1);
        List<List<String>> resList = new LinkedList<>();
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < len; j++) res[i][j] = "";
            resList.add(Arrays.asList(res[i]));
        }
        return resList;
    }

    private int getHeight(TreeNode node) {
        if (node == null) return 0;
        int left = getHeight(node.left);
        int right = getHeight(node.right);
        return Math.max(left, right) + 1;
    }

    private void helper(TreeNode node, String[][] res, int level, int begin, int end) {
        // put root
        if (node == null) return;
        int mid = (begin + end) / 2;
        res[level][mid] =  ""+node.val;
        helper(node.left, res, level+1, begin, mid-1);
        helper(node.right, res, level+1, mid + 1, end);
    }
}
