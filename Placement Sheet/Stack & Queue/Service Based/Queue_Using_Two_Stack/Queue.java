package Queue_Using_Two_Stack;

public class Queue {
    private Stack stack1;
    private Stack stack2;

    public Queue(int size) {
        this.stack1 = new Stack(size);
        this.stack2 = new Stack(size);
    }

    public boolean enqueue(int data) {
        if (stack1.isFull()) {
            System.out.println("Queue overflow...");
            return false;
        }
        stack1.push(data);
        return true;
    }

    public int dequeue() {
        if (stack1.isEmpty()) {
            System.out.println("Queue is empty...");
            return -1;
        }

        while (!stack1.isEmpty()) {
            stack2.push(stack1.pop());
        }

        int data = stack2.pop();

        while (!stack2.isEmpty()) {
            stack1.push(stack2.pop());
        }

        return data;
    }
}
