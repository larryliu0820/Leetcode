import java.util.Arrays;

/**
 * Created by Valued Customer on 7/17/2017.
 *
 * 621. Task Scheduler
 */
public class p621 {
    public int leastInterval(char[] tasks, int n) {
        int[] taskNum = new int[26];
        int count = 0;
        for (char c: tasks) {
            taskNum[c-'A']++;
            count = Math.max(count, taskNum[c-'A']);
        }
        int ans = (count-1) * (n+1);
        for (int i = 0; i < 26; i++) {
            if (taskNum[i] == count) ans++;
        }

        return Math.max(tasks.length, ans);
    }
}
