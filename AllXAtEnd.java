public class AllXAtEnd {
    public static void main(String[] args) {
        String str = "axbcxxd";
       String s1 = new String("");
        String s2 = new String("");
        int i =0;
        ending(str, s1, s2, i);
    }

    public static void ending(String str , String s1 , String s2,int i)
       {
        if(i==str.length())
        {
            System.out.println(s2+s1);
            return ;
        }
        if(str.charAt(i)=='x')
        {
           
            ending(str, s1+str.charAt(i), s2,i+1);
        }
        else{
            ending(str, s1, s2+str.charAt(i),i+1);
        }
       }
    
}
