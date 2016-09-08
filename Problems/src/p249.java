import java.util.LinkedList;
import java.util.List;

/**
 * Created by Valued Customer on 9/7/2016.
 * 249. Group Shifted Strings
 * Given a string, we can "shift" each of its letter to its successive letter, for example: "abc" -> "bcd". We can keep "shifting" which forms the sequence:

 "abc" -> "bcd" -> ... -> "xyz"
 Given a list of strings which contains only lowercase alphabets, group all strings that belong to the same shifting sequence.

 For example, given: ["abc", "bcd", "acef", "xyz", "az", "ba", "a", "z"],
 A solution is:

 [
 ["abc","bcd","xyz"],
 ["az","ba"],
 ["acef"],
 ["a","z"]
 ]
 */
public class p249 {
    public List<List<String>> groupStrings(String[] strings) {


        List<List<String>> result = new LinkedList<>();
        if (strings == null || strings.length == 0) return result;
        List<String> group = new LinkedList<>();
        group.add(strings[0]);
        result.add(group);
        for (int i = 1; i < strings.length; i++) {
            boolean found = false;
            for (int j = 0; j < result.size(); j++) {
                if (isGroup(strings[i], result.get(j).get(0))) {
                    result.get(j).add(strings[i]);
                    found = true;
                    break;
                }
            }
            if (!found) {
                List<String> g = new LinkedList<>();
                g.add(strings[i]);
                result.add(g);
            }
        }
        return result;
    }

    private boolean isGroup(String s1, String s2) {
        if (s1.length() != s2.length()) return false;
        if (s1.length() == 1) return true;
//        for (int i = 0; i < s2.length(); i++) {
            boolean group = true;
            for (int j = 1; j < s1.length(); j++) {
                int dist = s1.charAt(j) - s1.charAt(j-1);
                if (dist < 0) dist += 26;
//                int ind = (i+j) % s2.length();
//                int prev = (i+j-1) % s2.length();
                if ((s2.charAt(j-1) + dist - 'a') % 26 + 'a' != s2.charAt(j)) {group = false; break;}
            }
            if (group) return true;
//        }
        return false;
    }

    public static void main(String[] args) {
        p249 sol = new p249();
        String[] input = new String[]{"abc","bcd","acef","xyz","az","ba","a","z"};
        sol.groupStrings(input);
    }
}
