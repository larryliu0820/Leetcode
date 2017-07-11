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

    private int select(int[] A, int left, int right, int k) {
        if (left == right) return A[left];
        int pivotInd = (left + right) / 2;
        pivotInd = partition(A, left, right, pivotInd);
        if (k == pivotInd) return A[k];
        else if (k < pivotInd) return select(A, left, pivotInd - 1, k);
        else return select(A, pivotInd + 1, right, k);
    }

    private int partition(int[] A, int left, int right, int k) {
        int pivot = A[k];
        swap(A, k, right);
        int i = left, j = right;
        while (i < j) {
            while (i < j && A[i] >= pivot) i++;
            while (i < j && A[j] <= pivot) j--;
            swap(A, i, j);
        }
        swap(A, right, i);
        return i;
    }
    private void swap(int[] A, int i, int j) {
        if (i != j) {
            int temp = A[i];
            A[i] = A[j];
            A[j] = temp;
        }
    }
}
