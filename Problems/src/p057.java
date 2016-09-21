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
        List<Interval> result = new ArrayList<>();
        if (intervals == null || intervals.size() == 0 ) {
            result.add(newInterval);
            return result;
        }
        //binary search the index to merge/insert
        int index = 0;
        Interval curr = new Interval(newInterval.start, newInterval.end);
        if (newInterval.start < intervals.get(0).start) index = 0;
        else {
            int low = 0, high = intervals.size()-1;
            while (low <= high) {
                int mid = (low + high) / 2;
                if (newInterval.start >= intervals.get(mid).start) {
                    if (mid == intervals.size()-1 || newInterval.start < intervals.get(mid+1).start) {
                        index = mid;
                        break;
                    }
                    else low = mid+1;
                } else high = mid-1;
            }
            if (low == high) index = low;

            if (newInterval.start > intervals.get(index).end) {
                index++;
            } else {
                curr.start = intervals.get(index).start;
            }
        }
        int end = index;
        while (end < intervals.size() && intervals.get(end).end < newInterval.end) end++;


        for (int i = 0; i < index; i++) result.add(intervals.get(i));
        if (end == intervals.size()) {
            curr.end = newInterval.end;
        } else if (curr.end >= intervals.get(end).start){
            curr.end = intervals.get(end).end;
            end++;
        }

        result.add(curr);
        for (int i = end; i < intervals.size(); i++) result.add(intervals.get(i));
        return result;
    }
}
