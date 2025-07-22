package Delete_Kth_Node_From_End;

public class Main {
    Node head;
    Node tail;

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

    private void deleteKthNode(int k) {
        if (head == null) {
            System.out.println("List is empty...");
            return;
        }

        Node prevNode = head, currNode = head, endNode = head;

        // Find the size of the linkedlist...
        int size = 1;
        while (endNode.next != null) {
            size++;
            endNode = endNode.next;
        }
        System.out.println("Size of the linkedlist: " + size);

        if (k == size) {
            head = head.next;
            return;
        }

        // Find the node and delete...
        int count = 0;

        while (currNode != null) {
            if (size - count == k) {
                prevNode.next = currNode.next;
                break;
            }
            prevNode = currNode;
            currNode = currNode.next;
            count++;
        }
    }

    public static void main(String[] args) {
        Main list = new Main();
        list.insert(1);
        list.insert(2);
        list.insert(3);
        list.insert(4);
        list.display();
        list.deleteKthNode(2);
        list.display();
    }
}
