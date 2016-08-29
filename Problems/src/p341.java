/**
 * Created by larryliu on 8/28/16.
 * 341. Flatten Nested List Iterator
 * Given a nested list of integers, implement an iterator to flatten it.

 Each element is either an integer, or a list -- whose elements may also be integers or other lists.

 Example 1:
 Given the list [[1,1],2,[1,1]],

 By calling next repeatedly until hasNext returns false, the order of elements returned by next should be: [1,1,2,1,1].

 Example 2:
 Given the list [1,[4,[6]]],

 By calling next repeatedly until hasNext returns false, the order of elements returned by next should be: [1,4,6].
 */

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return null if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */
public class p341 implements Iterator<Integer> {

    List<NestedInteger> nestedIntegers;
    int nestedItr;
    List<Integer> result;
    int itr;
    public p341(List<NestedInteger> nestedList) {
        nestedIntegers = nestedList;
        nestedItr = 0;
        result = new LinkedList<>();
        itr = 0;
    }

    @Override
    public Integer next() {
        while (hasNext() && itr == result.size()) getNestedInteger(nestedIntegers.get(nestedItr++));
        if (itr < result.size()) return result.get(itr++);
        return null;
    }

    private void getNestedInteger(NestedInteger it) {
        if (it.isInteger()) {
            result.add(it.getInteger());

        } else {
            List<NestedInteger> list = it.getList();
            for (NestedInteger i : list) {
                getNestedInteger(i);
            }
        }
    }
    @Override
    public boolean hasNext() {
        while (itr == result.size() && nestedItr < nestedIntegers.size()) getNestedInteger(nestedIntegers.get(nestedItr++));
        if (itr == result.size() && nestedItr == nestedIntegers.size()) return false;
        return true;
    }
}
