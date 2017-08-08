/**
 * Created by Valued Customer on 7/26/2017.
 * 186. Reverse Words in a String II
 */
public class p186 {
    public void reverseWords(char[] s) {
        reverse(s, 0, s.length-1);
        boolean inWord = false;
        int wordHead = 0, wordTail = 0;
        for (;wordTail <= s.length; wordTail++) {
            if (wordTail < s.length && s[wordTail] != ' ' && !inWord) {
                inWord = true;
                wordHead = wordTail;
            }
            if (wordTail == s.length || s[wordTail] == ' ') {
                if (inWord) {
                    reverse(s, wordHead, wordTail - 1);
                    inWord = false;
                }
            }
        }
    }

    private void reverse(char[] s, int b, int e) {
        while (b < e) {
            char temp = s[b];
            s[b] = s[e];
            s[e] = temp;
            b++;
            e--;
        }
    }
}
