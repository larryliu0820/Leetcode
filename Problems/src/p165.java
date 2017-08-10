/**
 * Created by Valued Customer on 8/12/2016.
 * 165. Compare Version Numbers
 * Compare two version numbers version1 and version2.
 If version1 > version2 return 1, if version1 < version2 return -1, otherwise return 0.

 You may assume that the version strings are non-empty and contain only digits and the . character.
 The . character does not represent a decimal point and is used to separate number sequences.
 For instance, 2.5 is not "two and a half" or "half way to version three", it is the fifth second-level revision of the second first-level revision.

 Here is an example of version numbers ordering:

 0.1 < 1.1 < 1.2 < 13.37
 */
public class p165 {
    public int compareVersion(String version1, String version2) {
        String[] v1 = version1.split("\\.");
        String[] v2 = version2.split("\\.");
        int len1 = v1.length, len2 = v2.length;
        for (int i = 0; i < Math.max(len1, len2); i++) {
            int val1 = (i<len1)?Integer.parseInt(v1[i]):0;
            int val2 = (i<len2)?Integer.parseInt(v2[i]):0;
            if (val1 > val2) return 1;
            else if (val1 < val2) return -1;
        }
        return 0;
    }

    public static void main(String[] args) {
        p165 sol = new p165();
        sol.compareVersion("1.0","1.1");
    }
}
