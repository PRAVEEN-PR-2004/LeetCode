
import java.util.*;

public class GenerateParentheses {
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        helper(0, 0, n, ans, sb);
        return ans;
    }

    public void helper(int open, int close, int n, List<String> ans, StringBuilder sb) {
        if (close == n && open == n) {
            ans.add(sb.toString());
            return;
        }

        if (open < n) {
            sb.append("("); // Add an opening bracket
            helper(open + 1, close, n, ans, sb);
            sb.deleteCharAt(sb.length() - 1); // Backtrack
        }

        if (close < open) { // Add closing bracket only if unmatched opens are present
            sb.append(")"); // Add a closing bracket
            helper(open, close + 1, n, ans, sb);
            sb.deleteCharAt(sb.length() - 1); // Backtrack
        }
    }

    public static void main(String[] args) {
        GenerateParentheses solution = new GenerateParentheses();
        int n = 3; // You can change this value to test with different inputs
        List<String> result = solution.generateParenthesis(n);
        System.out.println("Generated Parentheses Combinations: ");
        for (String s : result) {
            System.out.println(s);
        }
    }
}
