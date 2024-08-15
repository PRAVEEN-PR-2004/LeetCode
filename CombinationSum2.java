import java.util.*;

public class CombinationSum2 {

    public static void main(String[] args) {
        int[] arr = {2, 5, 2, 1, 2};
        int target = 5;
        System.out.println(combinationSum(arr, target));
    }

    public static List<List<Integer>> combinationSum(int[] arr, int target) {
        List<List<Integer>> result = new ArrayList<>();
        if (arr.length == 0) {
            return result;
        }
        Arrays.sort(arr); 
        findCombinations(0, target, arr, new ArrayList<>(), result);
        return result;
    }

    public static void findCombinations(int index, int target, int[] arr, ArrayList<Integer> current, List<List<Integer>> result) {
        if (target == 0) {
            result.add(new ArrayList<>(current));
            return;
        }
        if (target < 0) {
            return;
        }

        for (int i = index; i < arr.length; i++) {
            if (i > index && arr[i] == arr[i - 1]) {
                continue; 
            }
            current.add(arr[i]);
            findCombinations(i + 1, target - arr[i], arr, current, result); 
            current.remove(current.size() - 1); 
        }
    }
}
