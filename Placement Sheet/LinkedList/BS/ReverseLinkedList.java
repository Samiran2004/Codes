public class ReverseLinkedList {
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

    private void reverseList() {
        if(head == null) {
            System.out.println("List is empty...");
            return;
        }
        Node prevNode = null;
        Node currNode = head;
        Node nextNode = null;
        tail = head;
        while (currNode != null) {
            nextNode = currNode.next;
            currNode.next = prevNode;
            prevNode = currNode;
            currNode = nextNode;
        }
        head = prevNode;
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
        ReverseLinkedList list1 = new ReverseLinkedList();
        list1.insert(1);
        list1.insert(2);
        list1.insert(3);
        list1.insert(4);
        list1.insert(5);
        list1.insert(6);
        list1.display();
        System.out.println("After reversal: ");
        list1.reverseList();
        list1.display();
    }
}
