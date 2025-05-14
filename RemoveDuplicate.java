import java.util.*;

public class RemoveDuplicate {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder("");
        boolean[] map = new boolean[26];
        duplicate("appnacollege", map, 0, sb);
    }

    public static void duplicate(String s, boolean[] map, int i, StringBuilder sb) {
        if (i == s.length()) {
            System.out.println(sb);
            return;
        }
        if (map[s.charAt(i) - 'a']) {
            duplicate(s, map, i + 1, sb);
        } else {
            map[s.charAt(i) - 'a'] = true;
            sb.append(s.charAt(i));
            duplicate(s, map, i + 1, sb);
        }
    }
}
