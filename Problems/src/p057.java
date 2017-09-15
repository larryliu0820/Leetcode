import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Valued Customer on 9/20/2016.
 * 57. Insert Interval
 * Given a set of non-overlapping intervals, insert a new interval into the intervals (merge if necessary).

 You may assume that the intervals were initially sorted according to their start times.

 Example 1:
 Given intervals [1,3],[6,9], insert and merge [2,5] in as [1,5],[6,9].

 Example 2:
 Given [1,2],[3,5],[6,7],[8,10],[12,16], insert and merge [4,9] in as [1,2],[3,10],[12,16].

 This is because the new interval [4,9] overlaps with [3,5],[6,7],[8,10].
 */
public class p057 {
    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        int beginIndex = binarySearch(intervals, newInterval.start);
        int endIndex = binarySearch(intervals, newInterval.end);
        if (beginIndex == -1 || intervals.get(beginIndex).end < newInterval.start) {
            intervals.add(++beginIndex, newInterval);
            endIndex ++;
        }
        intervals.get(beginIndex).end = Math.max(newInterval.end, intervals.get(endIndex).end);
        List<Interval> res = new LinkedList<>();
        for (int i = 0; i <= beginIndex; i++) {
            res.add(intervals.get(i));
        }

        for (int i = endIndex+1; i < intervals.size(); i++) {
            res.add(intervals.get(i));
        }
        return res;
    }

    private int binarySearch(List<Interval> intervals, int time) {
        int s = 0, e = intervals.size()-1;
        while (s <= e) {
            int m = (s + e) / 2;

            if (intervals.get(m).start <= time) {
                s = m + 1;
            } else {
                e = m - 1;
            }
        }
        return e;
    }

    public static void main(String[] args) {
        p057 sol = new p057();
        List<Interval> list = new LinkedList<>();
        list.add(new Interval(1,2));
        list.add(new Interval(3,5));
        list.add(new Interval(6,7));
        list.add(new Interval(8,10));
        list.add(new Interval(12,16));
        sol.insert(list, new Interval(0, 1));

    }
}
