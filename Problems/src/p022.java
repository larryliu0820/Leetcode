import java.util.LinkedList;
import java.util.List;

/**
 * Created by Larry Liu on 9/26/2017.
 * 22. Generate Parentheses
 */
public class p022 {
    public List<String> generateParenthesis(int n) {
        List<String> res = new LinkedList<>();
        helper(res, "", 0, n);
        return res;
    }
    private void helper(List<String> res, String curr, int left, int remain) {
        if (remain == 0 && left == 0) {
            res.add(curr);
            return;
        }
        if (remain > 0)
            helper(res, curr+'(', left+1, remain-1);
        if (left > 0)
            helper(res, curr+')', left-1, remain);
    }
}
