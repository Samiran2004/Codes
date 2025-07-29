package Implement_Queue_Using_LinkedList;

public class Queue {
    LinkedList queue;

    Queue() {
        queue = new LinkedList();
    }

    public boolean isEmpty() {
        return queue.isEmpty();
    }

    public void enqueue(int data) {
        queue.insert(data);
    }

    public int dequeue() {
        return queue.removeHead();
    }

    public int front() {
        return queue.frontData();
    }
}
