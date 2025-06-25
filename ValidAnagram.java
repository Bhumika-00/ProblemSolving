import java.util.HashMap;

public class ValidAnagram {
    public static void main(String[] args) {
        String str1 = "race";
        String str2 = "carerrr";

        if (str1.length() != str2.length()) {
            System.out.println("Not an anagram");
            return;
        }

        HashMap<Character, Integer> hmp = new HashMap<>();

         for(int i=0;i<str1.length();i++)
        {
            if(hmp.containsKey(str1.charAt(i)))
            {
                hmp.put(str1.charAt(i), hmp.get(str1.charAt(i))+1);
            }
            else{
                hmp.put(str1.charAt(i), 1);
            }
        }

       for(int i=0;i<str2.length();i++)
        {
           if(hmp.containsKey(str2.charAt(i)))
            {
                hmp.put(str2.charAt(i), hmp.get(str2.charAt(i))-1);
            } 
            else{
                System.out.println("Not valid");
            }

            if(hmp.get(str2.charAt(i))==0)
            {
                hmp.remove(str2.charAt(i));
            }
        }

        if (hmp.isEmpty()) {
            System.out.println("Anagram");
        } else {
            System.out.println("Not an anagram");
        }
    }
}
