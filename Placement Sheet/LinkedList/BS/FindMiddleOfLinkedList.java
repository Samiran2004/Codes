class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

public class FindMiddleOfLinkedList {
    private Node head;
    private Node tail;

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

    private int findMiddleNode() {
        if (head == null) {
            System.out.println("List is empty...");
            return head.data;
        }
        Node slowPtr = head;
        Node fastPtr = head;
        while (fastPtr != null && fastPtr.next != null) {
            slowPtr = slowPtr.next;
            fastPtr = fastPtr.next.next;
        }
        return slowPtr.data;

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
        System.out.println("NULL");
    }

    public static void main(String[] args) {
        FindMiddleOfLinkedList list1 = new FindMiddleOfLinkedList();
        list1.insert(1);
        list1.insert(2);
        list1.insert(3);
        list1.insert(4);
        list1.insert(5);
        list1.insert(6);
        list1.display();
        int middle = list1.findMiddleNode();
        System.out.println("Middle: " + middle);
    }
}