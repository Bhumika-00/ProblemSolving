public class LengthOfString {
    public static void main(String[] args) {
        String str = "bhumika";
        int count = 0;
        int i=0;
        length(str, count, i);
    }
    public static void length(String str , int count,int i)
    {
     if(i==str.length()-1)
     { System.out.println(count);
        return ;
     }
     length(str, count+1, i+1);
    
    }
}
