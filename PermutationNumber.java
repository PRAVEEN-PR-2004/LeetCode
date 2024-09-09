import java.util.*;
public class PermutationNumber {
    public static void main(String[] args)
    {
        int[] arr = {1,2,3};
        List<List<Integer>> aa  = permutation(arr);
        for(List a:aa)
        {
            System.out.print(a+" ");
        }


    }
    public static List<List<Integer>> permutation(int[] arr)
    {
        List<List<Integer>> al = new ArrayList<>();
        helper(arr,al,new ArrayList<>());
        return al;

    }
    public static void helper(int[] arr,List<List<Integer>> al,List<Integer> a)
    {
        if(a.size()== arr.length)
        {
            al.add(new ArrayList<>(a));
        }
        for(int num:arr)
        {
            if(a.contains(num))
            {
                continue;
            }
            a.add(num);
            helper(arr,al,a);
            a.remove(a.size()-1);
        }
    }
}
