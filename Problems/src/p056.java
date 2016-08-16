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
        List<Interval> result = new ArrayList<>();
        if (intervals == null || intervals.isEmpty()) return result;
        intervals.sort(IntervalStartComparator);
        result.add(new Interval(intervals.get(0).start, intervals.get(0).end));
        Interval curr = result.get(0);
        for (int i = 1; i < intervals.size(); i++) {
            while (curr.end > intervals.get(i).end) if (++i == intervals.size()) return result;
            if (curr.end >= intervals.get(i).start) {
                curr.end = intervals.get(i).end;
            } else {
                curr = new Interval(intervals.get(i).start, intervals.get(i).end);
                result.add(curr);
            }
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
