public class r9 {
    public static void main(String[] args) {
        System.out.println(zeros(30204, 0));
    }
    public static int zeros(int num,int count)
    {
        if(num==0)
        {
            return count;
        }
        if(num%10==0)
        {
            return zeros(num/10, count+1);
        }
        return zeros(num/10, count);
    }
}
