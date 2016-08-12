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
        if (!version1.contains(".") && !version2.contains(".")) {
            if (Integer.parseInt(version1) == Integer.parseInt(version2)) return 0;
            else if (Integer.parseInt(version1) < Integer.parseInt(version2)) return -1;
            else return 1;
        }
        String[] v1 = version1.split("\\.");
        String[] v2 = version2.split("\\.");

        int i = 0;
        int longLen = v1.length > v2.length?v1.length:v2.length;
        for (; i < longLen; i++) {
            int ver1 = 0;
            if (i < v1.length)
                ver1 = Integer.parseInt(v1[i]);
            int ver2 = 0;
            if (i < v2.length)
                ver2 = Integer.parseInt(v2[i]);
            if (ver1 < ver2) return -1;
            else if (ver1 > ver2) return 1;
        }

        return 0;
    }

    public static void main(String[] args) {
        p165 sol = new p165();
        sol.compareVersion("1.0","1.1");
    }
}
