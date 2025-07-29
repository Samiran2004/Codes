package Implement_Stack_With_Linked_List;

public class Main {
    public static void main(String[] args) {
        Stack stack = new Stack();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
        System.out.println("Top element: " + stack.top());
        stack.pop();
        System.out.println("Top Element: " + stack.top());
    }
}
