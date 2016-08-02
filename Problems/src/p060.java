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
        String res = "";
        for (int i = 1; i <= n; i++) {
            factSeq[i] = factSeq[i-1] * i;
            res += Integer.toString(i);
        }
        if (k > factSeq[n]) return null;
        List<Integer> seq = new ArrayList<>();
        int ind = n-1;
        while (k > 0) {
            int result = (k - 1) / factSeq[ind];
            seq.add(result);
            k = k % factSeq[ind];
            ind--;
        }

        for (int i = 0; i < seq.size(); i++) {
            System.out.println("seq.get(" + i + ") = " + seq.get(i));
            if (seq.get(i) == 0) break;
            char c1 = res.charAt(seq.get(i));
            char c2 = res.charAt(i);
            String sub1 = res.substring(i+1,seq.get(i));
            String sub2 = res.substring(seq.get(i)+1);
            res = c1 + sub1 + c2 + sub2;
        }
        for (int i : seq) System.out.println(i + ",");
        System.out.println(res);
        return "";
    }

    public static void main(String[] args) {
        p060 sol = new p060();
        sol.getPermutation(3,5);
    }
}
