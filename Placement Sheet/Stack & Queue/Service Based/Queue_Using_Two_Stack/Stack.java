package Queue_Using_Two_Stack;

public class Stack {
    private int maxSize;
    private int[] stackArr;
    private int top;

    Stack(int size) {
        this.maxSize = size;
        this.stackArr = new int[maxSize];
        this.top = -1;
    }

    public void push(int data) {
        if (top == maxSize - 1) {
            System.out.println("Stack overflow...");
            return;
        }
        stackArr[++top] = data;
        System.out.println(data + " is pushed in the stack...");
    }

    public int pop() {
        if (top == -1) {
            System.out.println("Stack underflow...");
            return -1;
        }

        int data = stackArr[top--];
        return data;
    }

    public int peek() {
        if (top == -1) {
            System.out.println("Stack underflow...");
            return -1;
        }
        return stackArr[top];
    }

    public boolean isEmpty() {
        return top == -1 ? true : false;
    }

    public boolean isFull() {
        return top == maxSize - 1 ? true : false;
    }

    public int getSize() {
        return top + 1;
    }
}
