import java.util.*;
public class Combination {
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int n=sc.nextInt();
        int m = sc.nextInt();
        List<List<Integer>> ans = combine(n,m);
        System.out.println(ans);
        sc.close();

    }
    public static List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> al = new ArrayList<>();
        List<Integer> a = new ArrayList<>();
        int[] arr = new int[n];
        for(int i=0;i<n;i++)
        {
            arr[i]=i+1;
        }
         combinations(0,k,arr,a,al);
         return al;
    }
    public static void combinations(int pos,int k,int[] arr,List<Integer> a,List<List<Integer>> al)
    {
        if(a.size()==k)
        {
            al.add(new ArrayList<>(a));
            return;
        }
        
        for(int i=pos;i<arr.length;i++)
        {
            int come = arr[i];
           
            a.add(come);
            combinations(i+1,k,arr,a,al);
            a.remove(a.size()-1);
        }
    }
}