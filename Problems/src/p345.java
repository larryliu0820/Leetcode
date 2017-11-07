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
        Set<Character> set = new HashSet<>();
        for (char c : "aeiouAEIOU".toCharArray()) set.add(c);
        char[] arr = s.toCharArray();
        int lo = 0, hi = s.length()-1;
        while (lo < hi) {
            while (lo < hi && !set.contains(arr[lo])) lo++;
            while (lo < hi && !set.contains(arr[hi])) hi--;
            if (lo < hi) swap(arr, lo++, hi--);
        }
        return String.valueOf(arr);
    }

    private void swap(char[] arr, int lo, int hi) {
        char temp = arr[lo];
        arr[lo] = arr[hi];
        arr[hi] = temp;
    }

    public static void main(String[] args) {
        p345 sol = new p345();
        System.out.println(sol.reverseVowels("hello"));
    }
}
