import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * Created by Valued Customer on 8/21/2016.
 * 253. Meeting Rooms II
 * Given an array of meeting time intervals consisting of start and end times [[s1,e1],[s2,e2],...] (si < ei), find the
 * minimum number of conference rooms required.

 For example,
 Given [[0, 30],[5, 10],[15, 20]],
 return 2.
 */
public class p253 {
    public static Comparator<Interval> IntervalStartComparator = new Comparator<Interval>() {
        @Override
        public int compare(Interval interval, Interval t1) {
            if (interval.start < t1.start) return -1;
            else if (interval.start > t1.start) return 1;
            return 0;
        }
    };
    public int minMeetingRooms(Interval[] intervals) {
        List<Interval> sorted = new ArrayList<>();
        for (Interval i : intervals) sorted.add(i);
        sorted.sort(IntervalStartComparator);

        List<Integer> endTimes = new ArrayList<>();
        for (int i = 0; i < sorted.size(); i ++) {
            Interval curr = sorted.get(i);
            if (endTimes.size() == 0) {
                endTimes.add(curr.end);
                continue;
            }
            boolean oneMore = true;
            for (int e = 0; e < endTimes.size(); e++) {
                if (curr.start < endTimes.get(e)) continue;
                else {
                    endTimes.remove(e);
                    endTimes.add(curr.end);
                    oneMore = false;
                    break;
                }
            }
            if (oneMore) endTimes.add(curr.end);
        }
        return endTimes.size();
    }

    public static void main(String[] args) {
        // [[1080,2236],[3325,5014],[1397,3851],[54,1519],[1794,2238],[2907,4858]]
        Interval[] input = new Interval[]{new Interval(1080,2236), new Interval(3325,5014), new Interval(1397, 3851),
        new Interval(54,1519), new Interval(1794,2238), new Interval(2907, 4858)};
        p253 sol = new p253();
        System.out.println(sol.minMeetingRooms(input));
    }

}
