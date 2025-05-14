public class NumbersToWords {
    public static void main(String[] args) {
        int num=1234;
        String dict[]={"Zero","One","Two","Three","Four","Five","Six","Seven","Eight","Nine"};
        StringBuilder sb = new StringBuilder("");
        conversion(num, dict, sb);
    }
    public static void conversion(int num , String dict[] , StringBuilder sb)
    {
     if(num==0)
     {
      return;
     }
     int lastdig = num%10;
    
     conversion(num/10, dict, sb.append(dict[lastdig]));
      System.out.print(dict[lastdig]+" ");
    }
}
