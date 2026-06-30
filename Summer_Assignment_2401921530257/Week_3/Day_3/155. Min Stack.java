import java.util.*;

class MinStack {
    private final Deque<Long> stack = new ArrayDeque<>();
    private long mini;

    public MinStack() {}

    public void push(int val) {
        if (stack.isEmpty()) {
            mini = val;
            stack.push((long) val);
        } else if (val >= mini) {
            stack.push((long) val);
        } else {
            stack.push(2L * val - mini);
            mini = val;
        }
    }

    public void pop() {
        long x = stack.pop();
        if (x < mini) {
            mini = 2L * mini - x;
        }
    }

    public int top() {
        long x = stack.peek();
        return (int) (x >= mini ? x : mini);
    }

    public int getMin() {
        return (int) mini;
    }
}
