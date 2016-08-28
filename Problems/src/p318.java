import java.util.Arrays;

/**
 * Created by Valued Customer on 8/20/2016.
 * 318. Maximum Product of Word Lengths
 * Given a string array words, find the maximum value of length(word[i]) * length(word[j]) where the two words do not
 * share common letters. You may assume that each word will contain only lower case letters. If no such two words exist, return 0.

 Example 1:
 Given ["abcw", "baz", "foo", "bar", "xtfn", "abcdef"]
 Return 16
 The two words can be "abcw", "xtfn".

 Example 2:
 Given ["a", "ab", "abc", "d", "cd", "bcd", "abcd"]
 Return 4
 The two words can be "ab", "cd".

 Example 3:
 Given ["a", "aa", "aaa", "aaaa"]
 Return 0
 No such pair of words.
 */
public class p318 {
    public int maxProduct(String[] words) {
        if (words == null || words.length == 0) return 0;
        int[] value = new int[words.length];

        for (int i = 0; i < words.length; i++) {
            String s = words[i];
            for (char c : s.toCharArray())
                value[i] |= 1<<(c-'a');
        }
        int max = 0;
        for (int i = 0; i < words.length-1; i++) {
            for (int j = i+1; j < words.length; j++) {
                if ((value[i] & value[j]) == 0 && words[i].length() * words[j].length() > max) max = words[i].length() * words[j].length();
            }
        }
        return max;
    }
}
