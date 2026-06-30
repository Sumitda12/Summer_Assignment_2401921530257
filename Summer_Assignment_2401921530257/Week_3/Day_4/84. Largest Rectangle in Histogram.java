import java.util.*;

class Solution {
    private int[] findPSE(int[] arr) {
        Deque<Integer> stack = new ArrayDeque<>();
        int[] pse = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            while (!stack.isEmpty() && arr[stack.peek()] >= arr[i]) {
                stack.pop();
            }
            pse[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(i);
        }
        return pse;
    }

    private int[] findNSE(int[] arr) {
        Deque<Integer> stack = new ArrayDeque<>();
        int[] nse = new int[arr.length];
        for (int i = arr.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && arr[stack.peek()] >= arr[i]) {
                stack.pop();
            }
            nse[i] = stack.isEmpty() ? arr.length : stack.peek();
            stack.push(i);
        }
        return nse;
    }

    public int largestRectangleArea(int[] heights) {
        int[] pse = findPSE(heights);
        int[] nse = findNSE(heights);
        int maxArea = 0;
        for (int i = 0; i < heights.length; i++) {
            int width = nse[i] - pse[i] - 1;
            maxArea = Math.max(maxArea, heights[i] * width);
        }
        return maxArea;
    }
}
