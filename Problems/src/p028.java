import java.util.ArrayList;

/**
 * Created by Valued Customer on 7/28/2016.
 * 28. Implement strStr()
 * Implement strStr().

 Returns the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.
 */
public class p028 {
    public int strStr(String haystack, String needle) {
        if (needle.length() == 0)
            return 0;
        ArrayList<Integer> indices = new ArrayList<>();

        for (int i = 0; i < haystack.length(); i ++) {
            if (haystack.charAt(i) == needle.charAt(0))
                indices.add(i);
        }
        for (int i : indices) {
            int ind = 0;
            while (haystack.charAt(i) == needle.charAt(ind)) {
                System.out.println("haystack["+i+"] = " + haystack.charAt(i));
                System.out.println("needle["+ind+"] = " + needle.charAt(ind));
                if (ind == needle.length()-1) return i-ind;
                ind ++;
                i++;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        p028 sol = new p028();
        sol.strStr("mississippi", "issip");
    }
}
