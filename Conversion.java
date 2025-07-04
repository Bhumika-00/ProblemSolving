import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class Conversion {
    public static void main(String[] args) {
        // HashMap with integer values as keys and Roman symbols as values
        HashMap<Integer, String> romanMap = new HashMap<>();
        romanMap.put(1, "I");
        romanMap.put(4, "IV");
        romanMap.put(5, "V");
        romanMap.put(9, "IX");
        romanMap.put(10, "X");
        romanMap.put(40, "XL");
        romanMap.put(50, "L");
        romanMap.put(90, "XC");
        romanMap.put(100, "C");
        romanMap.put(400, "CD");
        romanMap.put(500, "D");
        romanMap.put(900, "CM");
        romanMap.put(1000, "M");

        int num = 3749;

        ArrayList<Integer> romanSymbols = new ArrayList<>(romanMap.keySet());
        Collections.sort(romanSymbols);

        StringBuilder result = new StringBuilder();

        while (num > 0) {
            for (int i = 0; i < romanSymbols.size(); i++) {
                if (romanSymbols.get(i) > num) {
                    int key = romanSymbols.get(i - 1);
                    num -= key;
                    result.append(romanMap.get(key));
                    i = 0;
                    break;
                }

                if (i == romanSymbols.size() - 1) {
                    int key = romanSymbols.get(i);
                    num -= key;
                    result.append(romanMap.get(key));
                    i = 0;
                    break;
                }
            }
        }

        System.out.println(result.toString());
    }
}
