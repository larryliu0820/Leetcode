import java.util.ArrayList;
import java.util.List;

/**
 * Created by Valued Customer on 8/21/2016.
 * 346. Moving Average from Data Stream
 * Given a stream of integers and a window size, calculate the moving average of all integers in the sliding window.

 For example,
 MovingAverage m = new MovingAverage(3);
 m.next(1) = 1
 m.next(10) = (1 + 10) / 2
 m.next(3) = (1 + 10 + 3) / 3
 m.next(5) = (10 + 3 + 5) / 3
 */
public class p346 {
    /** Initialize your data structure here. */
    int sum;
    int size;
    int actualSize;
    List<Integer> values;
    public p346(int size) {
        this.size = size;
        actualSize = 0;
        sum = 0;
        values = new ArrayList<>();
    }

    public double next(int val) {

        sum += val;
        values.add(val);
        if (actualSize < size) {
            actualSize++;
        } else {
            sum -= values.get(0);
            values.remove(0);
        }
        return (double)sum/actualSize;
    }
}
