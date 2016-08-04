import java.util.ArrayList;
import java.util.List;

/**
 * Created by Valued Customer on 8/2/2016.
 * 60. Permutation Sequence
 * The set [1,2,3,…,n] contains a total of n! unique permutations.

 By listing and labeling all of the permutations in order,
 We get the following sequence (ie, for n = 3):

 "123"
 "132"
 "213"
 "231"
 "312"
 "321"
 Given n and k, return the kth permutation sequence.

 Note: Given n will be between 1 and 9 inclusive.
 */
public class p060 {
    public String getPermutation(int n, int k) {
        int[] factSeq = new int[n+1];
        factSeq[0] = 1;
        List<Integer> res = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            factSeq[i] = factSeq[i-1] * i;
            res.add(i);
        }
        if (k > factSeq[n]) return null;
        k = k - 1;
        for(int ind = n-1; ind > 0; ind--) {
            int r = k / factSeq[ind];
            // System.out.println("k = " + k + ", factSeq[" + ind + "] = " + factSeq[ind] + ", result = " + result);
//            System.out.print(r + ",");
            k = k % factSeq[ind];
            if (r == 0) continue;
            int pos = n-1-ind;

            int c = res.remove(r+pos) ;
            res.add(pos, c);
        }
//        return "";
        String result = "";
        for (int i : res) result += i;
        return result;
    }

    public static void main(String[] args) {
        p060 sol = new p060();
        System.out.println(sol.getPermutation(8,8590));
    }
}
