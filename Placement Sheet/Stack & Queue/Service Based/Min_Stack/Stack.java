package Min_Stack;

public class Stack {
    private int[] arr;
    private int size;
    private int capacity;

    public Stack(int capacity) {
        this.capacity = capacity;
        this.arr = new int[capacity];
        this.size = -1;
    }

    public void push(int data) {
        if (size >= capacity) {
            System.out.println("Stack Overflow...");
            return;
        }
        size++;
        arr[size] = data;
    }

    public int pop() {
        if (size <= -1) {
            System.out.println("Stack Underflow...");
            return -1;
        }
        int data = arr[size];
        size--;
        return data;
    }

    public int top() {
        if (size <= -1) {
            System.out.println("Stack is empty...");
            return -1;
        }
        return arr[size];
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return size <= -1 ? true : false;
    }

    public boolean isFull() {
        return size == capacity ? true : false;
    }
}
