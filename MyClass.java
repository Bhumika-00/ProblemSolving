import java.util.HashMap;
import java.util.*;
public class MyClass {
    public static void main(String[] args) {
        HashMap<String, Integer> countries = new HashMap<>();
        countries.put("India", 91);
        countries.put("USA", 1);
        countries.put("UK", 44);
        
        System.out.println(countries);
        Set<String> country = countries.keySet();
        System.out.println(country);
        for(String key : country)
        {
            System.out.println(countries.get(key));
        }
    }
}
