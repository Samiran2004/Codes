public class NthNodeFromLast {
    private Node head;
    private Node tail;

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

    public int nthNodeFromLast(int n) {
        if (head == null) {
            System.out.println("List is empty...");
            return -1;
        }
        Node fastPtr = head;
        Node slowPtr = head;
        for (int i = 0; i < n; i++) {
            if (fastPtr == null) {
                return -1;
            }
            fastPtr = fastPtr.next;
        }
        while (fastPtr != null) {
            fastPtr = fastPtr.next;
            slowPtr = slowPtr.next;
        }
        return (slowPtr != null) ? slowPtr.data : -1;
    }

    public static void main(String[] args) {
        NthNodeFromLast list = new NthNodeFromLast();
        list.insert(1);
        list.insert(2);
        list.insert(3);
        list.insert(4);
        list.insert(5);
        list.insert(6);
        list.insert(7);
        list.display();
        System.out.println("n'th node from last: " + list.nthNodeFromLast(2));
    }
}