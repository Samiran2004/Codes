package Implement_Stack_With_Linked_List;

public class LinkedList {
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

    public int removeEnd() {
        if (head == null)
            return -1;

        if (head == tail) {
            int data = head.data;
            head = tail = null;
            return data;
        }

        Node curr = head;
        while (curr.next != tail) {
            curr = curr.next;
        }
        int data = tail.data;
        tail = curr;
        tail.next = null;
        return data;
    }

    public int getTailData() {
        return tail != null ? tail.data : -1;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public int getSize() {
        int size = 0;
        if (head == null) {
            return size;
        }

        Node currNode = head;
        while (currNode != null) {
            size++;
            currNode = currNode.next;
        }
        return size;
    }
}
