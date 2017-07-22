/**
 * Created by Valued Customer on 7/13/2017.
 *
 * 565. Array Nesting
 *
 *
 */
public class p565 {
    public int arrayNesting(int[] nums) {
        boolean[] visited = new boolean[nums.length];
        int max = 1;
        for (int i = 0; i < nums.length; i++) {
            if (visited[i]) continue;
            visited[i] = true;
            int count = 1;
            int itr = i;
            while (nums[itr] != i) {
                visited[itr] = true;
                itr = nums[itr];
                count++;
            }
            max = Math.max(max, count);
        }
        return max;
    }
}
