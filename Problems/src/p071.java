import java.util.Stack;

/**
 * Created by Valued Customer on 8/4/2016.
 * 71. Simplify Path
 * Given an absolute path for a file (Unix-style), simplify it.

 For example,
 path = "/home/", => "/home"
 path = "/a/./b/../../c/", => "/c"
 */
public class p071 {
    public String simplifyPath(String path) {
        char[] p = path.toCharArray();
        if (path.equals("/")) return "/";
        String result = "";
        String dirName = "";
        Stack<String> directories = new Stack<>();
        for (int i = 0; i <= p.length; i++) {
            if (i == p.length || p[i] == '/' ) {
                if (dirName.length() > 0) {
                    if (dirName.equals("..")) {
                        if (!directories.isEmpty())
                            directories.pop();
                    } else if (!dirName.equals("."))
                        directories.push(dirName);
                    dirName = "";
                }
            } else {
                dirName += p[i];
            }
        }

        while (!directories.isEmpty()) {
            String dir = directories.pop();
            result = "/" + dir + result;
        }
        if (result.equals("")) result = "/";
        return result;
    }

    public static void main(String[] args) {
        p071 sol = new p071();
        System.out.println(sol.simplifyPath("/../c"));
    }
}
