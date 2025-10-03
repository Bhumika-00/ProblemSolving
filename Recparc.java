public class Recparc {
    public static void main(String[] args) {
        int n = 5;
        String str = "appnacollege";
        StringBuilder sb = new StringBuilder("");
        boolean dict[]=new boolean[26];
        dupliactes(str, 0, sb, dict);
        System.out.println(tiles(n));
        System.out.println(friends(4));
    }
    public static int tiles(int n)
    {
        if(n==0 || n==1)
        {
            return 1;
        }

        return tiles(n-1)+tiles(n-2);
    }
    public static void dupliactes(String str , int i , StringBuilder sb , boolean dict[])
    {
        if(i == str.length())
        {
            System.out.println(sb);
            return;
        }
        char curr = str.charAt(i);
        if(dict[curr-'a'])
        {
            dupliactes(str, i+1, sb, dict);
        }
        else{
            dict[curr-'a']=true;
            dupliactes(str, i+1, sb.append(curr), dict);
        }
    }
    public static int friends(int n)
    {
        if(n==1 || n==2)
        {
            return 1;
        }
        return friends(n-1)+2*friends(n-2);
    }
    public static void ones(int i , int str , int lastdig)
    {
        if(n==0)
        {
            System.out.println(str);
            return;
        }
        ones(i-1, str+"0",0);
        if(lastdig==0)
        {
            ones(i-1, str+"1", 1);
        }
    }
}
