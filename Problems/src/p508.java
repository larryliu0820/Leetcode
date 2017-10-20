import java.util.*;

/**
 * Created by Larry Liu on 10/16/2017.
 * 508. Most Frequent Subtree Sum
 */
public class p508 {
    public int[] findFrequentTreeSum(TreeNode root) {
        Map<Integer, Integer> res = new HashMap<>();
        helper(res, root);
        int maxCount = 0;
        List<Integer> sumList = new LinkedList<>();
        for (int key: res.keySet()) {
            if (maxCount < res.get(key)) {
                maxCount = res.get(key);
                sumList = new LinkedList<>();
                sumList.add(key);
            } else if (maxCount == res.get(key)) {
                sumList.add(key);
            }
        }
        int[] sumArray = new int[sumList.size()];
        for (int i = 0; i < sumArray.length; i++) sumArray[i] = sumList.get(i);
        return sumArray;
    }

    private int helper(Map<Integer, Integer> map, TreeNode node) {
        if (node == null) return 0;
        int leftSum = helper(map, node.left);
        int rightSum = helper(map, node.right);
        int sum = leftSum + rightSum + node.val;
        map.put(sum, map.getOrDefault(sum, 0) + 1);
        return sum;
    }
}
