package Stack_Implementation_Using_Queue;

public class Queue {
    private int[] arr;
    private int capacity;
    private int front;
    private int rear;
    private int size;

    public Queue(int capacity) {
        this.capacity = capacity;
        this.arr = new int[capacity];
        this.front = 0;
        this.rear = -1;
        this.size = 0;
    }

    public void enqueue(int data) {
        if (isFull()) {
            System.out.println("Queue is full...");
            return;
        }
        rear = (rear + 1) % capacity;
        arr[rear] = data;
        size++;
    }

    public int dequeue() {
        if (isEmpty()) {
            System.out.println("Queue is empty...");
            return -1;
        }

        int data = arr[front];
        front = (front + 1) % capacity;
        size--;
        return data;
    }

    public int peek() {
        if (isEmpty()) {
            System.out.println("Queue is empty...");
            return -1;
        }
        return arr[front];
    }

    public boolean isFull() {
        return size == capacity;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int getSize() {
        return size;
    }

}
