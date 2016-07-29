/**
 * Created by mengwliu on 7/28/16.
 * 31. Next Permutation
 *  Implement next permutation, which rearranges numbers into the lexicographically next greater permutation of numbers.

 If such arrangement is not possible, it must rearrange it as the lowest possible order (ie, sorted in ascending order).

 The replacement must be in-place, do not allocate extra memory.

 Here are some examples. Inputs are in the left-hand column and its corresponding outputs are in the right-hand column.
 1,2,3 → 1,3,2
 3,2,1 → 1,2,3
 1,1,5 → 1,5,1
 */
public class p031 {
    public void nextPermutation(int[] nums) {
        if (nums.length < 2) return;
        int last = nums.length - 1;
        int smallestInd = last;
        int biggestInd = last;
        int begin = last - 1;
        while (begin >= 0) {
            System.out.println("nums[" + begin + "] = " + nums[begin] + ", nums[" + biggestInd + "] = " + nums[biggestInd]);

            if (nums[begin] >= nums[biggestInd]) biggestInd = begin;
            else
                break;
            begin--;
        }
        if (begin >= 0) {
            for (last = smallestInd; last >= biggestInd; last--) {
                System.out.println("last = " + last + ", begin = " + begin);
                if (nums[last] > nums[begin]) {
                    swap(nums, begin, last);
                    break;
                }
            }
            begin++;
            last = nums.length - 1;
        } else
            begin = 0;
        while (begin < last) {
            swap(nums, begin++, last--);
        }
    }

    public void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    public static void main(String[] args) {
        p031 sol = new p031();
        int[] arr = new int[]{5,1,1};
        sol.nextPermutation(arr);
        for (int i : arr) System.out.println(i);
    }
}
