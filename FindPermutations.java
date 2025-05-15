public class FindPermutations {
    public static void main(String[] args) {
        String str="abc";
        String ans ="";
        permuations(str, ans);
    }
    public static void permuations(String str , String ans)
    {
     if(str.length()==0)
     {
        System.out.println(ans);
        return;
     }
     for(int i=0;i<str.length();i++)
     {
        char ch = str.charAt(i);
        String newstr = str.substring(0, i)+str.substring(i+1);
        permuations(newstr, ans+ch);
     }
    }
}
