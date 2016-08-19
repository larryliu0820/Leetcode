import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by Valued Customer on 8/19/2016.
 * 284. Peeking Iterator
 * Given an Iterator class interface with methods: next() and hasNext(), design and implement a PeekingIterator that
 * support the peek() operation -- it essentially peek() at the element that will be returned by the next call to next().

 Here is an example. Assume that the iterator is initialized to the beginning of the list: [1, 2, 3].

 Call next() gets you 1, the first element in the list.

 Now you call peek() and it returns 2, the next element. Calling next() after that still return 2.

 You call next() the final time and it returns 3, the last element. Calling hasNext() after that should return false.

 Show Hint

 */
public class p284 implements Iterator<Integer> {

    List<Integer> list;
    int ind;
    Iterator<Integer> itr2;
    public p284(Iterator<Integer> iterator) {
        // initialize any member here.
        list = new ArrayList<>();
        ind = -1;
        itr2 = iterator;
    }

    // Returns the next element in the iteration without advancing the iterator.
    public Integer peek() {
        if (ind < list.size()-1) {
            return list.get(ind+1);
        } else {
            Integer result = itr2.next();
            list.add(result);
            return result;
        }
    }

    // hasNext() and next() should behave the same as in the Iterator interface.
    // Override them if needed.
    @Override
    public Integer next() {
        Integer result = peek();
        ind++;
        return result;
    }

    @Override
    public boolean hasNext() {
        if (ind < list.size()-1) return true;
        return itr2.hasNext();
    }
}
