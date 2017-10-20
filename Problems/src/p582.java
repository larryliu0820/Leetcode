import java.util.*;

/**
 * Created by Larry Liu on 10/15/2017.
 * 582. Kill Process
 */
public class p582 {
    public List<Integer> killProcess(List<Integer> pid, List<Integer> ppid, int kill) {
        Map<Integer, Set<Integer>> pidMap = new HashMap<>();
        for (int i = 0; i < ppid.size(); i++) {
            pidMap.putIfAbsent(ppid.get(i), new HashSet<>());
            pidMap.get(ppid.get(i)).add(pid.get(i));
        }

        List<Integer> res = new LinkedList<>();
        Stack<Integer> stack = new Stack<>();
        stack.push(kill);
        while (!stack.isEmpty()) {
            int curr = stack.pop();
            res.add(curr);
            if (pidMap.containsKey(curr)) stack.addAll(pidMap.get(curr));
        }
        return res;
    }
}
