import java.util.*;

/**
 * Created by mengwliu on 8/29/17
 * 49. Group Anagrams
 */
public class p049 {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> memo = new HashMap<>();
        for (String str: strs) {
            char[] arr = str.toCharArray();
            Arrays.sort(arr);
            String sorted = String.valueOf(arr);
            if (!memo.containsKey(sorted)) {
                memo.put(sorted, new LinkedList<>());

            }
            memo.get(sorted).add(str);
        }
        return new LinkedList<>(memo.values());
    }

    public static void main(String[] args) {
        String[] strs = new String[] {"eat","tea","tan","ate","nat","bat"};
        p049 sol = new p049();
        List<List<String>> res = sol.groupAnagrams(strs);

    }
}
