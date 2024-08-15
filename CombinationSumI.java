import java.util.*;
public class CombinationSumI {

   
    public static void main(String[] args) 
    {
       
        int[] nums = {2,3,6,7};
        int n = 7;
        System.out.println(combinationSum(nums,n));
    }

    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> al = new ArrayList<>();
        if(candidates.length==0)
        {
            return al;
        }
        posCom(0,0,new ArrayList<Integer>(),candidates,target, al );
        return al;


    }
   public static void posCom(int sum,int pos,List<Integer> a,int[] candidates,int target, List<List<Integer>> al )
   {
        if(sum>target || pos>=candidates.length)
        {
            return;
        }
        if(sum == target)
        {
            al.add(new ArrayList<>(a));
            return;
        }
        for(int i=pos;i<candidates.length;i++)
        {
            a.add(candidates[i]);
            posCom(sum+candidates[i], i, a, candidates, target,al);
            a.remove(a.size()-1);
        }
   }
}