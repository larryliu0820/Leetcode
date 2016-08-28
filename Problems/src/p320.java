import java.util.ArrayList;
import java.util.List;

/**
 * Created by Valued Customer on 8/21/2016.
 * 320. Generalized Abbreviation
 * Write a function to generate the generalized abbreviations of a word.

 Example:
 Given word = "word", return the following list (order does not matter):
 ["word", "1ord", "w1rd", "wo1d", "wor1", "2rd", "w2d", "wo2", "1o1d", "1or1", "w1r1", "1o2", "2r1", "3d", "w3", "4"]
 */
public class p320 {
    public List<String> generateAbbreviations(String word) {
        List<String> result = new ArrayList<>();
        result.add(word);
        for (int i = 0; i < word.length(); i++) {
            dpHelper(result, word, i);
        }
        return result;
    }

    public void dpHelper(List<String> result, String word, int ind) {
        int size = result.size();
        for (int n = 0; n < size; n++) {
            String s = result.get(n);
            char[] sc = s.toCharArray();
            int i = 0;
            int left = -1;
            for (int j = 0; j < sc.length; j++) {
                if (i == ind) {
                    left = j-1;
                    break;
                }
                if (isDigit(sc[j])) {
                    int k = j;
                    while (j < sc.length && isDigit(sc[j])) j++;
                    i+= (Integer.parseInt(s.substring(k, j)));
                    j--;
                }
                else i++;
            }
            StringBuilder sb = new StringBuilder();
            if (left != -1) {
                if (isDigit(sc[left])) {
                    int j = left;
                    while( j >= 0 && isDigit(sc[j])) j--;
                    if (j != -1) sb.append(s.substring(0,j+1));
                    int num = Integer.parseInt(s.substring(j+1, left+1)) + 1;
                    sb.append(String.valueOf(num));
                } else {
                    sb.append(s.substring(0, left+1));
                    sb.append('1');
                }
            } else sb.append('1');

            if (s.length() > left + 2)
                sb.append(s.substring(left + 2));
            result.add(sb.toString());

        }
    }

    public boolean isDigit(char c) {
        return (c - '0' < 10 && c - '0' >= 0);
    }

    public static void main(String[] args) {
        p320 sol = new p320();
        System.out.println(sol.generateAbbreviations("word").toString());

    }
}
