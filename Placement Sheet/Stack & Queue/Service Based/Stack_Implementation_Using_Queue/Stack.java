package Stack_Implementation_Using_Queue;

public class Stack {
    private Queue queue1;
    private Queue queue2;
    private int size;

    public Stack(int capacity) {
        this.queue1 = new Queue(capacity);
        this.queue2 = new Queue(capacity);
        this.size = 0;
    }

    public void push(int data) {
        if (queue1.isFull()) {
            System.out.println("Stack overflow...");
            return;
        }
        queue1.enqueue(data);
        size++;
    }

    public int top() {
        if (queue1.isEmpty()) {
            System.out.println("Stack underflow...");
            return -1;
        }
        while (queue1.getSize() != 1) {
            queue2.enqueue(queue1.dequeue());
        }

        int data = queue1.dequeue();

        while (queue2.getSize() != 0) {
            queue1.enqueue(queue2.dequeue());
        }
        queue1.enqueue(data);
        return data;
    }

    public int pop() {
        if (queue1.isEmpty()) {
            System.out.println("Stack underflow...");
            return -1;
        }
        while (queue1.getSize() != 1) {
            queue2.enqueue(queue1.dequeue());
        }

        int data = queue1.dequeue();

        while (queue2.getSize() != 0) {
            queue1.enqueue(queue2.dequeue());
        }

        size--;

        return data;
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }
}
