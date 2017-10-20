/**
 * Created by Larry Liu on 10/15/2017.
 * 255. Verify Preorder Sequence in Binary Search Tree
 */
public class p255 {
    public boolean verifyPreorder(int[] preorder) {
        int low = Integer.MIN_VALUE, i = -1;
        for (int p : preorder) {
            if (p < low)
                return false;
            while (i >= 0 && p > preorder[i])
                low = preorder[i--];
            preorder[++i] = p;
        }
        return true;
    }

}
