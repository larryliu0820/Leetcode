import java.util.Queue;
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
        String[] dirNames = path.split("/");
        Stack<String> stack = new Stack<>();
        for (String dir : dirNames) {
            if (dir.equals("") || dir.equals(".")) continue;
            if (dir.equals("..")) {
                if (!stack.isEmpty()) stack.pop();
            } else stack.push(dir);
        }
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.insert(0, stack.pop());
            sb.insert(0, "/");

        }
        if (sb.length() == 0) sb.append("/");
        return sb.toString();
    }

    public static void main(String[] args) {
        p071 sol = new p071();
        System.out.println(sol.simplifyPath("/../c"));
    }
}
