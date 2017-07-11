/**
 * Created by Valued Customer on 7/6/2017.
 *
 * 557. Reverse Words in a String III
 *
 * Given a string, you need to reverse the order of characters in each word within a sentence while still preserving whitespace and initial word order.

 Example 1:
 Input: "Let's take LeetCode contest"
 Output: "s'teL ekat edoCteeL tsetnoc"
 Note: In the string, each word is separated by single space and there will not be any extra space in the string.
 */
public class p557 {
    public String reverseWords(String s) {
        String[] words = s.split(" ");
        StringBuilder sb = new StringBuilder();
        for (int i = words.length - 1; i >= 0; i--) {
            sb.append(words[i]);
            sb.append(' ');
        }
        sb.deleteCharAt(sb.length()-1);
        sb.reverse();
        return sb.toString();
    }
}
