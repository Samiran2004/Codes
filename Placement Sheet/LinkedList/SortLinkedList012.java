public class SortLinkedList012 {
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

    // Insert...
    public void insert(int data) {
        Node newNode = new Node(data);
        if (this.head == null) {
            this.head = newNode;
            this.tail = newNode;
            return;
        }
        tail.next = newNode;
        tail = newNode;
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

    public void sort012() {
        if (head == null) {
            System.out.println("List is empty...");
            return;
        }
        Node zeroD = new Node(0), oneD = new Node(0), twoD = new Node(0);
        Node zero = zeroD, one = oneD, two = twoD;
        Node currNode = head;
        while (currNode != null) {
            if (currNode.data == 0) {
                zero.next = currNode;
                zero = zero.next;
            } else if (currNode.data == 1) {
                one.next = currNode;
                one = one.next;
            } else {
                two.next = currNode;
                two = two.next;
            }
            currNode = currNode.next;
        }
        zero.next = oneD.next != null ? oneD.next : twoD.next;
        one.next = twoD.next;
        two.next = null;
        head = zeroD.next;
    }

    public static void main(String[] args) {
        SortLinkedList012 list = new SortLinkedList012();
        list.insert(1);
        list.insert(2);
        list.insert(0);
        list.insert(1);
        list.insert(2);
        list.insert(0);
        System.out.print("Before sorting: ");
        list.display();
        System.out.print("After sorting: ");
        list.sort012();
        list.display();
    }
}