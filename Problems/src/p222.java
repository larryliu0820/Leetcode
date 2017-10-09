/**
 * Created by Larry Liu on 10/8/2017.
 * 222. Count Complete Tree Nodes
 */
public class p222 {
    enum Direction {
        LEFT,
        RIGHT
    }
    public int countNodes(TreeNode root) {
        if (root == null) return 0;
        int leftHeight = getHeight(root, Direction.LEFT) + 1;
        int rightHeight = getHeight(root, Direction.RIGHT) + 1;

        if (leftHeight == rightHeight) return 2<<(leftHeight-1) - 1;
        else {
            return countNodes(root.left) + countNodes(root.right) + 1;
        }
    }

    private int getHeight(TreeNode node, Direction dir) {
        if (node == null) return 0;
        int height = 0;
        if (dir == Direction.LEFT) {
            while (node.left != null) {
                height++;
                node = node.left;
            }
        } else {
            while (node.right != null) {
                height++;
                node = node.right;
            }
        }

        return height;
    }

}
