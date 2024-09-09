
import java.util.*;

public class LetterCom {
    static HashMap<Integer, String> hs = new HashMap<>();
    static List<String> al = new ArrayList<>();

    public List<String> letterCombinations(String digits) {
        al.clear();
        hs.put(1, "");
        hs.put(2, "abc");
        hs.put(3, "def");
        hs.put(4, "ghi");
        hs.put(5, "jkl");
        hs.put(6, "mno");
        hs.put(7, "pqrs");
        hs.put(8, "tuv");
        hs.put(9, "wxyz");
        if (digits.length() == 0) {
            return al;
        }
        com("", digits, al);
        return al;
    }

    public static void com(String ans, String no, List<String> al) {
        if (no.length() == 0) {
            al.add(ans);
            return;
        }
        int digit = no.charAt(0) - '0';
        String combinations = hs.get(digit);
        for (int i = 0; i < combinations.length(); i++) {
            char toAdd = combinations.charAt(i);
            com(ans + toAdd, no.substring(1), al);
        }
    }

    public static void main(String[] args) {
        LetterCom sol = new LetterCom();
        String digits = "23"; 
        List<String> result = sol.letterCombinations(digits);
        System.out.println("Combination: " + result);
    }
}
