package Stack_Implementation_Using_Array;

public class Stack {
    private int capacity;
    private int size = 0;
    private int[] arr;

    Stack(int capacity) {
        this.capacity = capacity;
        this.arr = new int[capacity];
    }

    public void push(int num) {
        if (isFull() == 1) {
            return;
        }
        arr[size] = num;
        size++;
    }

    public int pop() {
        if (isEmpty() == 1) {
            return -1;
        }
        size--;
        return arr[size];
    }

    public int top() {
        if (size == 0) {
            return -1;
        }
        return arr[size - 1];
    }

    public int isEmpty() {
        return size == 0 ? 1 : 0;
    }

    public int isFull() {
        return size == capacity ? 1 : 0;
    }
}
