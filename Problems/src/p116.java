import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by Valued Customer on 8/2/2017.
 * 116. Populating Next Right Pointers in Each Node
 */
public class p116 {
    public void connect(TreeLinkNode root) {
        if (root == null) return;
        Queue<TreeLinkNode> currLevel = new LinkedList<>();
        Queue<TreeLinkNode> nextLevel = new LinkedList<>();
        currLevel.add(root);
        while (!currLevel.isEmpty()) {
            TreeLinkNode itr = currLevel.poll();
            if (itr.left != null) nextLevel.offer(itr.left);
            if (itr.right != null) nextLevel.offer(itr.right);
            while (!currLevel.isEmpty()) {
                itr.next = currLevel.poll();
                itr = itr.next;
                if (itr.left != null) nextLevel.offer(itr.left);
                if (itr.right != null) nextLevel.offer(itr.right);
            }
            itr.next = null;
            Queue<TreeLinkNode> temp = currLevel;
            currLevel = nextLevel;
            nextLevel = temp;
        }
    }
}
