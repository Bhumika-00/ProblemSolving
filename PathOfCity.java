import java.util.HashSet;

import javax.print.attribute.standard.Destination;

public class PathOfCity {
    public static void main(String[] args) {
        String cities[][]={{"Chennai" , "Banglore"},{"Mumbai","Delhi"},{"Goa","Chennai"},{"Delhi","Goa"}};
        HashSet<String> source=new HashSet<>();
        HashSet<String> destination = new HashSet<>();

        for (String[] city : cities)
        {
            source.add(city[0]);
            destination.add(city[1]);
        }
        // System.out.println(source);
        // System.out.println(destination);
        String start=null;
        for(String st : source)
        {
            if(!destination.contains(st))
            {
                start=st;
                break;
            }
        }
        System.out.println(start);
        String end = null;
        for(String et : destination)
        {
            if(!source.contains(et))
            {
                end=et;
                break;
            }
        }
       System.out.println(end);

       String current =start;
       System.out.print(current);
       while(true)
       {
        String next =null;
        for(String[]city : cities)
        {
            if(city[0].equals(current))
            {
                next = city[1];
                break;
            }
        }
        if(next==null)
        {
           break;
        }
        System.out.print("-->"+ next);
        current = next;
       }
    }
}
