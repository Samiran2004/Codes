import java.util.Stack;

public class MinStack {
    Stack<Integer> stack = new Stack<>();
    Stack<Integer> minStack = new Stack<>();

    // Push...
    public void push(int data) {
        stack.push(data);
        if (minStack.size() == 0 || data <= getMin()) {
            minStack.push(data);
        }
    }

    // Pop...
    public int pop() {
        int poppedElm = stack.pop();
        if (getMin() == poppedElm) {
            minStack.pop();
        }
        return poppedElm;
    }

    // Peek...
    public int peek() {
        return stack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }

    public static void main(String[] args) {
        MinStack stack = new MinStack();
        stack.push(5);
        stack.push(3);
        stack.push(7);
        stack.push(2);

        System.out.println("Min: " + stack.getMin());

        stack.pop();
        System.out.println("Min: " + stack.getMin());
        System.out.println("Top: " + stack.peek());
    }
}
