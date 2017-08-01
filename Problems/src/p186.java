/**
 * Created by Valued Customer on 7/26/2017.
 * 186. Reverse Words in a String II
 */
public class p186 {
    public void reverseWords(char[] s) {
        int wordBegin = 0, wordEnd = 0;
        if (s == null || s.length == 0) return;
        boolean isWord = s[0] != ' ';
        for (; wordEnd <= s.length; wordEnd++) {
            if (wordEnd == s.length || s[wordEnd] == ' ') {
                if (isWord) {
                    reverse(s, wordBegin, wordEnd - 1);
                    wordBegin = wordEnd;
                    isWord = false;
                } else wordBegin ++;
            } else {
                if (!isWord) wordBegin = wordEnd;
                isWord = true;
            }
        }
        reverse(s, 0, s.length-1);
    }

    private void reverse(char[] s, int begin, int end) {
        if (begin < 0 || end < 0 || begin >= s.length || end >= s.length || begin > end) return;
        int i = begin, j = end;
        while (i < j) {
            char temp = s[i];
            s[i++] = s[j];
            s[j--] = temp;
        }
    }
}
