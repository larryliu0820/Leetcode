import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * Created by Valued Customer on 8/14/2016.
 * 56. Merge Intervals
 * Given a collection of intervals, merge all overlapping intervals.

 For example,
 Given [1,3],[2,6],[8,10],[15,18],
 return [1,6],[8,10],[15,18].
 */
public class p056 {
    public static Comparator<Interval> IntervalStartComparator = new Comparator<Interval>() {
        @Override
        public int compare(Interval interval, Interval t1) {
            if (interval.start < t1.start) return -1;
            else if (interval.start > t1.start) return 1;
            return 0;
        }
    };
    public List<Interval> merge(List<Interval> intervals) {
        intervals.sort(IntervalStartComparator);
        List<Interval> result = new ArrayList<>();
        int next = 1;
        Interval curr = intervals.get(0);
        while ( next < intervals.size()) {
            while (curr.end > intervals.get(next).end) {
                next ++;
            }
            Interval merged = new Interval();
            merged.start = curr.start;
            if (curr.end >= intervals.get(next).start) {
                merged.end = intervals.get(next).end;
                curr = merged;
            } else {
                merged.end = Math.min(intervals.get(next-1).end, curr.end);
                curr = intervals.get(next);
            }
            next++;
            result.add(merged);
        }
        return result;
    }

    public static void main(String[] args) {
        p056 sol = new p056();
        List<Interval> intervals = new ArrayList<>();
        intervals.add(new Interval(1,3));
        intervals.add(new Interval(2,6));
        intervals.add(new Interval(8,10));
        intervals.add(new Interval(15,18));
        List<Interval> result = sol.merge(intervals);
    }
}
