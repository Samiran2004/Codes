public class LinkedListQueue {
    public static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    private Node head = null;
    private Node tail = null;

    // Enqueue...
    public void enqueue(int data) {
        Node newNode = new Node(data);
        if (this.head == null) {
            this.head = newNode;
            this.tail = newNode;
            return;
        }
        tail.next = newNode;
        tail = newNode;
    }

    //Dequeue...
    public int dequeue() {
        if (head == null) {
            throw new RuntimeException("Queue is empty...");
        }
        int value = head.data;
        head = head.next;
        return value;
    }    

    // Display...
    public void display() {
        if (head == null) {
            System.out.println("List is empty...");
            return;
        }
        Node currNode = head;
        while (currNode != null) {
            System.out.print(currNode.data + " --> ");
            currNode = currNode.next;
        }
        System.out.println("Null");
    }

    public static void main(String[] args) {
        LinkedListQueue queue = new LinkedListQueue();
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        queue.enqueue(4);
        queue.enqueue(5);
        queue.enqueue(6);
        queue.display();
        queue.dequeue();
        queue.display();
    }
}