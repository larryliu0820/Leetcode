import java.util.ArrayList;
import java.util.List;

/**
 * Created by Valued Customer on 8/17/2016.
 * 281. Zigzag Iterator
 * Given two 1d vectors, implement an iterator to return their elements alternately.

 For example, given two 1d vectors:

 v1 = [1, 2]
 v2 = [3, 4, 5, 6]
 By calling next repeatedly until hasNext returns false, the order of elements returned by next should be: [1, 3, 2, 4, 5, 6].

 Follow up: What if you are given k 1d vectors? How well can your code be extended to such cases?

 Clarification for the follow up question - Update (2015-09-18):
 The "Zigzag" order is not clearly defined and is ambiguous for k > 2 cases. If "Zigzag" does not look right to you, replace "Zigzag" with "Cyclic". For example, given the following input:

 [1,2,3]
 [4,5,6,7]
 [8,9]
 It should return [1,4,8,2,5,9,3,6,7].
 */
public class p281 {
    private List<List<Integer>> list = new ArrayList<>();
    private int row = 0;
    private int ind = 0;
    private int maxLen = 0;
    public p281(List<Integer> v1, List<Integer> v2) {
        list.add(v1);
        list.add(v2);
        if (v1.size() == 0) row = 1;
        maxLen = v1.size() > v2.size() ? v1.size() : v2.size();

    }

    public int next() {
        int result = list.get(row).get(ind);

        if (row == 0 ) {
            if (ind < list.get(1).size()) row = 1;
            else ind++;
        } else {
            ind++;
            if (ind < list.get(0).size()) row = 0;
        }
        return result;
    }

    public boolean hasNext() {
        return ind < maxLen-1;
    }
}
