public class PairWiseSwap {
    public static class Node {
        int data;
        Node next;

        // Constructor...
        Node(int data) {
            this.data = data;
            this.next = next;
        }
    }

    private Node head = null;
    private Node tail = null;

    // Insert...
    public void insert(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            tail = newNode;
            return;
        }
        Node currNode = head;
        while (currNode.next != null) {
            currNode = currNode.next;
        }
        currNode.next = newNode;
        tail.next = newNode;
        tail = newNode;
    }

    // Display List...
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

    // Swapping...
    public void pairSwap() {
        if (head == null) {
            System.out.println("List is empty...");
            return;
        }
        Node dummyNode = new Node(0);
        dummyNode.next = head;
        Node prevNode = dummyNode;

        while (prevNode.next != null && prevNode.next.next != null) {
            Node firsNode = prevNode.next;
            Node secondNode = firsNode.next;

            firsNode.next = secondNode.next;
            secondNode.next = firsNode;
            prevNode.next = secondNode;
            prevNode = firsNode;
        }
        head = dummyNode.next;
    }

    public static void main(String[] args) {
        PairWiseSwap list = new PairWiseSwap();
        list.insert(1);
        list.insert(2);
        list.insert(3);
        list.insert(4);
        list.insert(5);
        list.insert(6);
        System.out.print("Before swapping: ");
        list.display();
        System.out.println();
        System.out.println("After swapping: ");
        list.pairSwap();
        list.display();
    }
}