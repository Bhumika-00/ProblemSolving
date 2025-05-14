public class r8 {
    public static void main(String[] args) {
        int num=1234;
        int lg = (int)Math.floor(Math.log10(num));
        System.out.println(reverse(num, lg));
    }
    public static int reverse(int num , int lg)
    {
        if(num==0)
        {
            return 0;
        }
        return (num%10*(int)Math.pow(10, lg))+reverse(num/10, lg-1);
    }
}
