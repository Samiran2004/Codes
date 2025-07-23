package Swap_Nodes_In_Pairs;

public class Main {

    Node head = null;
    Node tail = null;

    private void insert(int data) {
        Node newNode = new Node(data);

        if (head == null) {
            head = newNode;
            tail = newNode;
            return;
        }

        newNode.next = tail.next;
        tail.next = newNode;
        tail = newNode;
    }

    private void display() {
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

    private void swapInPairs() {
        if (head == null) {
            System.out.println("List is empty...");
            return;
        }

        if (head.next == null) {
            return;
        }

        Node dummyNode = new Node(0);
        dummyNode.next = head;
        Node prevNode = dummyNode;

        while (prevNode.next != null && prevNode.next.next != null) {
            Node firstNode = prevNode.next;
            Node secNode = prevNode.next.next;

            firstNode.next = secNode.next;
            secNode.next = firstNode;
            prevNode.next = secNode;

            prevNode = firstNode;
        }

        head = dummyNode.next;
    }

    public static void main(String[] args) {
        Main list = new Main();
        list.insert(11);
        list.insert(21);
        list.insert(14);
        list.insert(13);
        list.insert(15);

        list.display();

        list.swapInPairs();
        list.display();
    }
}
