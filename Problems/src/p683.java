/**
 * Created by mengwliu on 11/7/17.
 * 683. K Empty Slots
 */
public class p683 {
    public int kEmptySlots(int[] flowers, int k) {
        int[] days = new int[flowers.length+1];
        for (int i = 0; i < flowers.length; i++) days[flowers[i]] = i;
        int left = 1, right = k + 2;
        int res = Integer.MAX_VALUE;

        for (int i = left; right < days.length; i++) {
            if (days[i] < days[left] || days[i] <= days[right]) {
                if (i == right) res = Math.min(res, Math.max(days[left], days[right])+1);
                left = i;
                right = left + k + 1;
            }
        }


        return res == Integer.MAX_VALUE?-1:res;
    }
}
