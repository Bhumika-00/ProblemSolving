public class SetSubset {
    public static void main(String[] args) {
       String str = "abcdef";
       int i=0;
       String newstr="";
       subset(str, newstr, i);
    }
    public static void subset(String str , String newstr , int i)
    {
        if(i==str.length())
        {
            System.out.println(newstr);
           return;
        }
        subset(str, newstr+str.charAt(i), i+1);
        
        subset(str, newstr, i+1);
    }
}
