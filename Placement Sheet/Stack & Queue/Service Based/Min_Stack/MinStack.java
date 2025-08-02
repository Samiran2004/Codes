package Min_Stack;

public class MinStack {
    private Stack stack;
    private Stack minStack;

    public MinStack(int capacity) {
        this.stack = new Stack(capacity);
        this.minStack = new Stack(capacity);
    }

    public void push(int num) {
        stack.push(num);

        if (minStack.isEmpty() || num <= minStack.top()) {
            minStack.push(num);
        } else {
            minStack.push(minStack.top());
        }
    }

    public int pop() {
        if (stack.isEmpty()) {
            return -1;
        }
        minStack.pop();
        return stack.pop();
    }

    public int top() {
        if (stack.isEmpty()) {
            return -1;
        }
        return stack.top();
    }

    public int getMin() {
        if (minStack.isEmpty()) {
            return -1;
        }
        return minStack.top();
    }
}
