public class ReverseOfNumberRecursion {
    public static void main(String[] args) {
        int digits = (int)Math.floor(Math.log10(1234));
        System.out.println(Reverse(1234, digits));
    }
    public static int Reverse(int num , int digits)
    {
        if(num==0)
        {
            return 0;
        }
        return (num%10*(int)Math.pow(10, digits))+Reverse(num/10, digits-1);

    }
}
