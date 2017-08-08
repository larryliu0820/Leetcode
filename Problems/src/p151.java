/**
 * Created by Valued Customer on 8/2/2017.
 *
 */
public class p151 {
    public String reverseWords(String s) {
        char[] sc = s.toCharArray();
        reverse(sc, 0, sc.length-1);
        boolean inWord = false;
        int wordHead = 0, wordTail = 0;
        for (;wordTail <= sc.length; wordTail++) {
            if (wordTail < sc.length && sc[wordTail] != ' ' && !inWord) {
                inWord = true;
                wordHead = wordTail;
            }
            if (wordTail == sc.length || sc[wordTail] == ' ') {
                if (inWord) {
                    reverse(sc, wordHead, wordTail - 1);
                    inWord = false;
                }
            }
        }
        return cleanSpace(sc, sc.length);
    }
    private void reverse(char[] s, int b, int e) {
        while (b < e) {
            char temp = s[b];
            s[b++] = s[e];
            s[e--] = temp;
        }
    }

    private String cleanSpace(char[] a, int n) {
        int i = 0, j = 0;
        while (j < n) {
            while (j < n && a[j] == ' ') j++;
            while (j < n && a[j] != ' ') a[i++] = a[j++];
            while (j < n && a[j] == ' ') j++;
            if (j < n) a[i++] = ' ';
        }
        return new String(a).substring(0, i);
    }
}
