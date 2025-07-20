public class RotateLinkedList {
    private Node head = null;
    private Node tail = null;

    public void insert(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            this.head = newNode;
            this.tail = newNode;
            return;
        }
        newNode.next = tail.next;
        tail.next = newNode;
        tail = newNode;
    }

    public void rotateList(int k) {
        if (head == null) {
            System.out.println("List is empty...");
            return;
        }
        int length = 1;
        Node tempNode = head;
        while (tempNode.next != null) {
            tempNode = tempNode.next;
            length++;
        }
        tempNode.next = head;

        k = k % length;
        tempNode = head;
        for (int i = 0; i < length - k - 1; i++) {
            tempNode = tempNode.next;
        }
        head = tempNode.next;
        tempNode.next = null;
        tail = tempNode;
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

    public static void main(String[] args) {
        RotateLinkedList list = new RotateLinkedList();
        list.insert(1);
        list.insert(2);
        list.insert(3);
        list.insert(4);
        list.insert(5);
        list.insert(6);
        list.display();
        list.rotateList(3);
        list.display();
    }
}