package Stack_Implementation_Using_Queue;

public class Main {
    public static void main(String[] args) {
        Stack stack = new Stack(5);
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
        System.out.println("Size of the stack: " + stack.getSize());
        System.out.println("Top element: " + stack.top());
        System.out.println("Poped element: " + stack.pop());
        System.out.println("Top element: " + stack.top());
    }
}
