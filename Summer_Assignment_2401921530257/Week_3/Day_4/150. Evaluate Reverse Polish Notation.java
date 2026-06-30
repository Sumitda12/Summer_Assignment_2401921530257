import java.util.*;

class Solution {
    public int evalRPN(String[] tokens) {
        Deque<Integer> stack = new ArrayDeque<>();
        for (String token : tokens) {
            if ("+-*/".contains(token)) {
                int b = stack.pop();
                int a = stack.pop();
                switch (token) {
                    case "+" -> stack.push(a + b);
                    case "-" -> stack.push(a - b);
                    case "*" -> stack.push(a * b);
                    default -> stack.push(a / b);
                }
            } else {
                stack.push(Integer.parseInt(token));
            }
        }
        return stack.peek();
    }
}
