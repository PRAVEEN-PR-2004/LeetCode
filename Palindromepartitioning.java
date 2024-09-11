import java.util.*;
public class Palindromepartitioning
{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        List<List<String>> ans = logic(s);
        System.out.println(ans);
    }
    public static List<List<String>> logic(String s)
    {
        List<List<String>> al = new ArrayList<>();
        List<String> a = new ArrayList<>();
        helper(al,a,s);
        return al;
    }
    public static boolean isPalindrome(String str)
    {
        int l = 0;
        int r = str.length()-1;
        while(l<=r)
        {
            if(str.charAt(l)!=str.charAt(r))
            {
                return false;
            }
            l++;
            r--;
        }
        return true;
    }
    public static void helper(List<List<String>> al,List<String> a,String s)
    {
        if(s.length()==0)
        {
            al.add(new ArrayList<>(a));
            return;
        }
        for(int i=0;i<s.length();i++)
        {
            String ss = s.substring(0, i+1);
            if(isPalindrome(ss))
            {
                a.add(ss);
                helper(al,a,s.substring(i+1));
                a.remove(a.size()-1);
            }
        }
    }
}