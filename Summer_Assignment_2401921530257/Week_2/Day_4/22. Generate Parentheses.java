import java.util.*;

class Solution {
    private void solve(String s, int open, int close, List<String> ans) {
        if (open == 0 && close == 0) {
            ans.add(s);
            return;
        }
        if (open == close) {
            solve(s + '(', open - 1, close, ans);
        } else if (open == 0) {
            solve(s + ')', open, close - 1, ans);
        } else if (close == 0) {
            solve(s + '(', open - 1, close, ans);
        } else {
            solve(s + '(', open - 1, close, ans);
            solve(s + ')', open, close - 1, ans);
        }
    }

    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        solve("", n, n, ans);
        return ans;
    }
}
