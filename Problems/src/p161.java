/**
 * Created by Valued Customer on 8/11/2016.
 * 161. One Edit Distance
 * Given two strings S and T, determine if they are both one edit distance apart.
 */
public class p161 {
    public boolean isOneEditDistance(String s, String t) {
        if (Math.abs(s.length() - t.length()) > 1) return false;
        int sMinusT = s.length() - t.length();
        int editDist = 0;
        int i = 0, j = 0;
        while(i < s.length() && j < t.length()) {
            if (s.charAt(i) != t.charAt(j)) {
                if (editDist == 1) return false;
                editDist++;
                if (sMinusT == 1) {i++; continue;}
                if (sMinusT == -1) {j++; continue;}
            }
            i++;
            j++;
        }
        if ((sMinusT == 1 && i == s.length()-1) || (sMinusT == -1 && j == t.length()-1)) editDist++;
        return editDist == 1;
    }
}
