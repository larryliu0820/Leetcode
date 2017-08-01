/**
 * Created by Valued Customer on 7/28/2017.
 * 189. Rotate Array
 */
public class p189 {
    public void rotate(int[] nums, int k) {
        k %= nums.length;
        int i = 0;
        int j = nums.length-1;
        while (i < j) swap(nums, i++, j--);
        i = 0;
        j = k-1;
        while (i < j) swap(nums, i++, j--);
        i = k;
        j = nums.length-1;
        while (i < j) swap(nums, i++, j--);
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
