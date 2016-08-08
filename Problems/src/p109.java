/**
 * Created by Valued Customer on 8/7/2016.
 * 109. Convert Sorted List to Binary Search Tree
 * Given a singly linked list where elements are sorted in ascending order, convert it to a height balanced BST.
 */
public class p109 {
    public TreeNode sortedListToBST(ListNode head) {
        ListNode end = head;
        ListNode mid = head;
        if (head == null) return null;
        if (head.next == null) return new TreeNode(head.val);
        while (end != null && end.next != null && end.next.next != null) {
            end = end.next.next;
            if (end == null || end.next == null || end.next.next == null) break;
            mid = mid.next;
        }
        TreeNode root = new TreeNode(mid.next.val);
        ListNode rightHead = mid.next.next;
        mid.next = null;
        root.left = sortedListToBST(head);
        root.right = sortedListToBST(rightHead);
        return root;
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
        p109 sol = new p109();
        ListNode head = new ListNode(0);
        ListNode itr = head;
        for (int i = 1; i < 10; i++) {
            itr.next = new ListNode(i);
            itr = itr.next;
        }
        TreeNode root = sol.sortedListToBST(head);
        sol.printTree(root);
    }
}
