import java.util.*;

/**
 * Created by Valued Customer on 8/17/2016.
 * 345. Reverse Vowels of a String
 * Write a function that takes a string as input and reverse only the vowels of a string.

 Example 1:
 Given s = "hello", return "holle".

 Example 2:
 Given s = "leetcode", return "leotcede".

 Note:
 The vowels does not include the letter "y".
 */
public class p345 {
    public String reverseVowels(String s) {
        Stack<String> vowels = new Stack<>();
        List<Integer> indices = new ArrayList<>();
        if (s == null || s.length() == 0) return s;
        Set<Character> v = new HashSet<>();
        for (char c: "aeiouAEIOU".toCharArray())
            v.add(c);
        int forward = 0;
        int backward = s.length()-1;
        char[] sb = s.toCharArray();
        while(forward < backward) {
            if (v.contains(sb[forward]) && v.contains(sb[backward])) {
                char tmp = sb[backward];
                sb[backward] = sb[forward];
                sb[forward] = tmp;
                forward++;
                backward--;
            }
            if (!v.contains(sb[forward])) forward++;
            if (!v.contains(sb[backward])) backward--;
        }

        return String.valueOf(sb);
    }

    public static void main(String[] args) {
        p345 sol = new p345();
        System.out.println(sol.reverseVowels("hello"));
    }
}
