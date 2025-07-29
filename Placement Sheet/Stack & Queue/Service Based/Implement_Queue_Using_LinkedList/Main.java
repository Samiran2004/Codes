package Implement_Queue_Using_LinkedList;

public class Main {
    public static void main(String[] args) {
        Queue queue = new Queue();
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        queue.enqueue(4);
        queue.enqueue(5);

        System.out.println("Front data: "+ queue.front());
        System.out.println("Dequeue data: "+ queue.dequeue());
        System.out.println("Front data: "+ queue.front());
        System.out.println("Dequeue data: "+ queue.dequeue());
        System.out.println("Front data: "+ queue.front());
    }
}
