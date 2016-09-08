import java.util.Iterator;
import java.util.List;

/**
 * Created by Valued Customer on 9/7/2016.
 * 251. Flatten 2D Vector
 * Implement an iterator to flatten a 2d vector.

 For example,
 Given 2d vector =

 [
 [1,2],
 [3],
 [4,5,6]
 ]
 By calling next repeatedly until hasNext returns false, the order of elements returned by next should be: [1,2,3,4,5,6].

 Show Hint

 */
public class p251 implements Iterator<Integer> {
    int row;
    int col;
    List<List<Integer>> vec;
    public p251(List<List<Integer>> vec2d) {
        vec = vec2d;
        row = 0;
        col = 0;
    }

    @Override
    public Integer next() {
        while (vec.get(row).size() == 0) row++;
        int result = vec.get(row).get(col);
        if (col == vec.get(row).size() - 1) {
            row++;
            col = 0;
        } else col++;
        return result;
    }

    @Override
    public boolean hasNext() {
        if (row >= vec.size()) return false;
        if (row == vec.size() - 1 && col >= vec.get(row).size()) return false;
        for (int i = row; i < vec.size(); i++) {
            if (vec.get(i).size() > 0)
                return true;
        }
        return false;
    }
}
