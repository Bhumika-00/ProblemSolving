public class TowerOfHanoi {
    public static void main(String[] args) {
        int n=3;
        char S='A';
        char H='B';
        char D='C';
        solution(n, S, H, D);
    }
    public static void solution(int n , char S , char H , char D)
    {
     if(n==1)
     {
        System.out.println(n +"transeffred from "+S+" to "+D);
        return;
     }
     solution(n-1, S, D, H);
     System.out.println(n +"transeffred from "+S+" to "+D);
     solution(n-1, H, S, D);
    }
}
