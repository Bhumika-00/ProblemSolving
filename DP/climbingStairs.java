import java.util.Arrays;

public class climbingStairs {
    public static void main(String[] args) {
        int n = 5;

        int memo[] = new int[n + 1];
        Arrays.fill(memo, -1);

        int tab[] = new int[n + 1];

        System.out.println("Recursive: " + climbingRec(n));
        System.out.println("Memoization: " + climbingMemo(n, memo));
        System.out.println("Tabulation: " + climbingTab(n, tab));
    }

    public static int climbingRec(int n) {
        if (n == 0 || n == 1) return 1;
        if (n < 0) return 0;
        return climbingRec(n - 1) + climbingRec(n - 2);
    }

    public static int climbingMemo(int n, int memo[]) {
        if (n == 0 || n == 1) return 1;
        if (n < 0) return 0;

        if (memo[n] != -1) return memo[n];

        memo[n] = climbingMemo(n - 1, memo) + climbingMemo(n - 2, memo);
        return memo[n];
    }

    public static int climbingTab(int n, int tab[]) {
        tab[0] = 1;
        tab[1] = 1;

        for (int i = 2; i <= n; i++) {
            tab[i] = tab[i - 1] + tab[i - 2];
        }
        return tab[n];
    }
}
