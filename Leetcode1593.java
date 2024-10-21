
import java.util.HashSet;
import java.util.Set;

public class Leetcode1593 {
    private int max; // Instance variable to store the maximum result

    public int maxUniqueSplit(String s) {
        max = 0; // Initialize max at the start
        Set<String> hs = new HashSet<>();
        helper(s, 0, hs); // Call helper method
        return max; // Return the result stored in the instance variable
    }

    public void helper(String s, int start, Set<String> hs) {
        if (start == s.length()) {
            // Update max if we found more unique splits
            max = Math.max(max, hs.size());
            return;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = start; i < s.length(); i++) {
            sb.append(s.charAt(i));
            String currentSubstr = sb.toString();
            if (!hs.contains(currentSubstr)) {
                hs.add(currentSubstr); // Add the substring
                helper(s, i + 1, hs); // Recursive call to explore the next split
                hs.remove(currentSubstr); // Backtrack to try other splits
            }
        }
    }

    public static void main(String[] args) {
        Leetcode1593 sol = new Leetcode1593();

        // Test cases
        String test1 = "ababccc";
        System.out.println("Max Unique Split of \"" + test1 + "\": " + sol.maxUniqueSplit(test1)); // Expected output: 5

        String test2 = "aba";
        System.out.println("Max Unique Split of \"" + test2 + "\": " + sol.maxUniqueSplit(test2)); // Expected output: 2

        String test3 = "abcabc";
        System.out.println("Max Unique Split of \"" + test3 + "\": " + sol.maxUniqueSplit(test3)); // Expected output: 6
    }
}
