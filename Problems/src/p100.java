/**
 * Created by Larry Liu on 10/6/2017.
 * 100. Same Tree
 */
public class p100 {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) return true;
        else if (p == null || q == null) return false;
        if (p.val != q.val) return false;
        boolean isLeft = isSameTree(p.left, q.left);
        boolean isRight = isSameTree(p.right, q.right);
        return isLeft && isRight;
    }
}
