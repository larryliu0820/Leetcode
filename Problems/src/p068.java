import java.util.LinkedList;
import java.util.List;

/**
 * Created by mengwliu on 9/3/17
 * 68. Text Justification
 */
public class p068 {
    class Line {
        List<String> words;
        int totalWordsLen;
        int maxWidth;
        boolean isLast;
        public Line(int mw) {
            words = new LinkedList<>();
            totalWordsLen = 0;
            maxWidth = mw;
            isLast = false;
        }
        public String toString() {
            StringBuilder sb = new StringBuilder();
            int numOfSpaces = maxWidth - totalWordsLen;
            int residual = words.size() == 1? 0: numOfSpaces % (words.size()-1);
            for (int i = 0; i < words.size(); i++) {
                sb.append(words.get(i));
                if (!isLast) {
                    if (i == 0 || i != words.size() - 1) {
                        for (int j = 0; j < (words.size() == 1 ? numOfSpaces : (numOfSpaces / (words.size() - 1))); j++)
                            sb.append(" ");
                        if (residual-- > 0) sb.append(" ");
                    }
                } else {
                    if (i != words.size() - 1) {
                        sb.append(" ");
                        numOfSpaces--;
                    } else {
                        for (int j = 0; j < numOfSpaces; j++) sb.append(" ");
                    }
                }
            }
            return sb.toString();
        }
    }
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<Line> lines = new LinkedList<>();
        List<String> res = new LinkedList<>();
        for (int i = 0; i < words.length;) {
            Line line = new Line(maxWidth);

            while (i < words.length && line.totalWordsLen + words[i].length() + line.words.size() <= maxWidth) {
                line.totalWordsLen += words[i].length();
                line.words.add(words[i++]);
            }

            lines.add(line);
            if (i >= words.length) line.isLast = true;
            res.add(line.toString());
        }
        return res;
    }

    public static void main(String[] args) {
        p068 sol = new p068();
        String[] words = new String[]{"This", "is", "an", "example", "of", "text", "justification."};
        sol.fullJustify(words, 16);
    }
}
