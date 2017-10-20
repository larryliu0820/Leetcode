import sun.reflect.generics.tree.Tree;

import java.util.*;

/**
 * Created by Larry Liu on 10/14/2017.
 * 606. Construct String from Binary Tree
 */
public class p606 {
    public String tree2str(TreeNode t) {
        if (t == null) return "";
        String res = "" + t.val;

        String left = tree2str(t.left);
        String right = tree2str(t.right);

        if (t.left == null && t.right == null) return res;
        if (t.right == null) return res + "(" + left + ")";
        return res + "(" + left + ")" + "(" + right + ")";
    }
}
