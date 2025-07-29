package Implement_Queue_Using_LinkedList;

public class LinkedList {
    Node head = null;
    Node tail = null;

    public void insert(int data) {
        Node newNode = new Node(data);
        if(head == null) {
            head = newNode;
            tail = newNode;
            return;
        }
        newNode.next = tail.next;
        tail.next = newNode;
        tail = newNode;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public int frontData() {
        return head != null ? head.data : -1;
    }

    public int removeHead() {
        if (head == null) {
            return -1;
        }

        int data = head.data;
        head = head.next;

        if(head == null) {
            tail = null;
        }

        return data;
    }
}
