public class largeststring {
    public static void main(String[] args) {
        String str[]={"apple","mango","banana"};
        String largest = str[0];
        for(int i=0;i<str.length;i++)
        {
            if(largest.compareTo(str[i])<0)
            {
                largest=str[i];
            }
        }
        System.out.println(largest);
    }
}
