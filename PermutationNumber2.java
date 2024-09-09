import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PermutationNumber2 {
    public static void main(String[] args) {
        int[] arr = {1, 2,1, 3};
        Arrays.sort(arr);  // Sort the array for lexicographical order, if required
        List<List<Integer>> aa = permutation(arr);
        for (List<Integer> a : aa) {
            System.out.println(a);
        }
    }

    public static List<List<Integer>> permutation(int[] arr) {
        List<List<Integer>> al = new ArrayList<>();
        boolean[] tf = new boolean[arr.length];
        helper(al, arr, new ArrayList<>(), tf);
        return al;
    }

    public static void helper(List<List<Integer>> al, int[] arr, List<Integer> a, boolean[] tf) {
        if (a.size() == arr.length) {
        
            if(!al.contains(a))
            {

                al.add(new ArrayList<>(a));  // Create a new list, otherwise references will be shared
            }
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            if (!tf[i]) {  // If the element is not used
                tf[i] = true;  // Mark it as used
                a.add(arr[i]);  // Add element to current permutation
                helper(al, arr, a, tf);  // Recur to add the next element
                a.remove(a.size() - 1);  // Backtrack: remove the element
                tf[i] = false;  // Mark it as unused for further permutations
            }
        }
    }
}
