import java.util.LinkedList;
import java.util.Queue;

public class FirstNonRepeating {
    public static void main(String[] args) {
        Queue<Character> q1 = new LinkedList<>();
        String str = "aabccxb";
        int arr[] = new int[26];  // frequency array

        for (int i = 0; i < str.length(); i++) {
            char curr = str.charAt(i);
            arr[curr - 'a']++;
            q1.add(curr);

            while (!q1.isEmpty() && arr[q1.peek() - 'a'] > 1) {
                q1.remove();
            }

            if (q1.isEmpty()) {
                System.out.print(-1 + " ");
            } else {
                System.out.print(q1.peek() + " ");
            }
        }
    }
}
