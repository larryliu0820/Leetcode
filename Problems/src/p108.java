/**
 * Created by Larry Liu on 10/6/2017.
 * 108. Convert Sorted Array to Binary Search Tree
 */
public class p108 {
    public TreeNode sortedArrayToBST(int[] nums) {
        return helper(nums, 0, nums.length-1);
    }

    private TreeNode helper(int[] nums, int begin, int end) {
        if (begin > end) return null;
        int mid = (begin + end) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = helper(nums, begin, mid-1);
        root.right = helper(nums, mid+1, end);
        return root;
    }
}
