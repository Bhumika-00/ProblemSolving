import java.util.Stack;

public class p8 {
    public static void main(String[] args) {
        int height[] = {2, 1, 5, 6, 7, 2, 3};
        int n = height.length;

        int nextSmallRight[] = new int[n];
        int nextSmallLeft[] = new int[n];

        nextSmallerRight(height, nextSmallRight);
        nextSmallerLeft(height, nextSmallLeft);

        int maxArea = 0;
        for (int i = 0; i < n; i++) {
            int width = nextSmallRight[i] - nextSmallLeft[i] - 1;
            int area = width * height[i];
            maxArea = Math.max(maxArea, area);
        }

        System.out.println(maxArea); // ✅ Should print 10
    }

    public static void nextSmallerRight(int[] height, int[] nsr) {
        Stack<Integer> stack = new Stack<>();
        int n = height.length;

        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && height[stack.peek()] >= height[i]) {
                stack.pop();
            }
            if (stack.isEmpty()) {
                nsr[i] = n;
            } else {
                nsr[i] = stack.peek();
            }
            stack.push(i);
        }
    }

    public static void nextSmallerLeft(int[] height, int[] nsl) {
        Stack<Integer> stack = new Stack<>();
        int n = height.length;

        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && height[stack.peek()] >= height[i]) {
                stack.pop();
            }
            if (stack.isEmpty()) {
                nsl[i] = -1;
            } else {
                nsl[i] = stack.peek();
            }
            stack.push(i);
        }
    }
}
