package Valid_Parentheses;

public class Stack {

    private char[] stackArr;
    private int capacity;
    private int size;

    public Stack(int capacity) {
        this.capacity = capacity;
        this.stackArr = new char[capacity];
        this.size = -1;
    }

    public void push(char data) {
        if (this.isFull()) {
            return;
        }
        size++;
        stackArr[size] = data;
    }

    public char pop() {
        if (isEmpty()) {
            System.out.println("Stack is empty...");
            return '\0';
        }
        char data = stackArr[size--];
        return data;
    }

    public char peek() {
        if (isEmpty()) {
            System.out.println("Stack is empty...");
            return '\0';
        }
        return stackArr[size];
    }

    public boolean isFull() {
        return size == capacity;
    }

    public boolean isEmpty() {
        return size == -1;
    }
}
