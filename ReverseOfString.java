public class ReverseOfString {
    public static void main(String[] args) {
        String str = "abcd";
        StringBuilder sb = new StringBuilder(" ");
        int i = str.length()-1;
        reverse(str, sb, i);
    }
    public static void reverse(String str , StringBuilder sb , int i)
    {
    if(i<0)
    {
        System.out.println(sb);
        return;
    }
    reverse(str, sb.append(str.charAt(i)), i-1);
    }
}
