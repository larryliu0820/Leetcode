import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

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
    int size;
    double sum;
    Queue<Integer> queue;
    public p346(int size) {
        this.size = size;
        this.sum = 0;
        this.queue = new LinkedList<>();
    }

    public double next(int val) {
        if (queue.size() <= size) {
            sum += val;
            queue.offer(val);
        }

        while (queue.size() > size) sum -= queue.poll();
        return sum / (size > queue.size() ? queue.size() : size);
    }
}
