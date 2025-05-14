public class BinaryStrings {
    public static void main(String[] args) {
        String s = new String("");
        binary(7, 0, s);
    }
    public static void binary(int n , int lastdig , String s)
    {
        if(n==0)
        {
        System.out.println(s);
        return ;
        }

        if(lastdig == 0)
        {
            binary(n-1, 1, s+"1");
        }
        binary(n-1, 0, s+"0");
    }
}
