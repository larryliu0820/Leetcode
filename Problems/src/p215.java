import java.util.PriorityQueue;

/**
 * Created by Valued Customer on 7/4/2017.
 *
 * 215. Kth Largest Element in an Array
 *
 * Find the kth largest element in an unsorted array. Note that it is the kth largest element in the sorted order,
 * not the kth distinct element.

 For example,
 Given [3,2,1,5,6,4] and k = 2, return 5.

 Note:
 You may assume k is always valid, 1 ≤ k ≤ array's length.
 */
public class p215 {
    public int findKthLargest(int[] nums, int k) {
        return select(nums, 0, nums.length-1, k-1);
    }

    private int select(int[] nums, int i, int j, int k) {
        int pivot = (i+j) / 2;
        int pivotVal = nums[pivot];
        swap(nums, pivot, j);
        int pivotNewPos = partition(nums, i, j, pivotVal);
        swap(nums, j, pivotNewPos);
        if (pivotNewPos == k) return nums[pivotNewPos];
        else if (pivotNewPos > k) return select(nums, i, pivotNewPos-1, k);
        else return select(nums, pivotNewPos+1, j, k);
    }

    private int partition(int[] nums, int i, int j, int pivotVal) {
        int s = i, e = j-1;
        while (s < e) {
            while (s < e && nums[s] >= pivotVal) s++;
            while (s < e && nums[e] <= pivotVal) e--;
            if (s < e) swap(nums, s, e);
        }
        return nums[s] <= pivotVal?s:j;
    }
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        p215 sol = new p215();
        sol.findKthLargest(new int[]{3, 1, 2, 4}, 2);
    }
}
