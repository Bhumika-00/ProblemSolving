public class NumberOfZeroesRecursion {
    public static void main(String[] args) {
        counting(102089, 0);
    }
    public static void counting(int num,int ct)
    {
        if(num==0)
        {
          System.out.println(ct);
          return ;  
        }
        int lastdig = num%10;
        if(lastdig==0)
        {
            counting(num/10,ct+1);
        }
        else{
            counting(num/10,ct);
        }
    }
}
