package Min_Stack;

public class Main {
    public static void main(String[] args) {
        MinStack minStack = new MinStack(3);
        minStack.push(2);
        minStack.push(1);
        minStack.push(3);

        System.out.println("Min: " + minStack.getMin());
        minStack.pop();
        System.out.println("Min: " + minStack.getMin());
        minStack.pop();
        System.out.println("Min: " + minStack.getMin());
    }
}
