public class RemoveLoopInLinkedlist {
    private Node head = null;
    private Node tail = null;

    public void insert(int data) {
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
        System.out.println("NULL");
    }

    public void removeLoop() {
        if (head == null) {
            System.out.println("List is empty...");
            return;
        }
        Node slowPtr = head;
        Node fastPtr = head;
        while (slowPtr != null && fastPtr != null && fastPtr.next != null) {
            slowPtr = slowPtr.next;
            fastPtr = fastPtr.next.next;
            if (slowPtr == fastPtr) {
                fastPtr.next = null;
            }
        }
    }

    public static void main(String[] args) {
        RemoveLoopInLinkedlist list = new RemoveLoopInLinkedlist();
        list.insert(1);
        list.insert(2);
        list.insert(3);
        list.insert(4);
        list.insert(5);
        list.insert(6);
        list.insert(7);
        list.display();
        list.head.next.next.next.next.next.next.next = list.head.next;
        list.removeLoop();
        list.display();
    }
}
