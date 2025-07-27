package Segregate_Odd_Even;

import java.util.ArrayList;

public class Main {

    Node head = null;
    Node tail = null;

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

    private void segregateOddEven() {
        if (head == null) {
            System.out.println("List is empty...");
            return;
        }

        ArrayList<Integer> oddArr = new ArrayList<>();
        ArrayList<Integer> evenArr = new ArrayList<>();
        Node currNode = head;
        while (currNode != null) {
            if (currNode.data % 2 == 0) {
                evenArr.add(currNode.data);
            } else {
                oddArr.add(currNode.data);
            }

            currNode = currNode.next;
        }

        Node dummyHead = new Node(0);
        Node prevNode = dummyHead;

        for (int i = 0; i < oddArr.size(); i++) {
            Node newNode = new Node(oddArr.get(i));
            prevNode.next = newNode;
            prevNode = newNode;
        }

        for (int i = 0; i < evenArr.size(); i++) {
            Node newNode = new Node(evenArr.get(i));
            prevNode.next = newNode;
            prevNode = newNode;
        }

        head = dummyHead.next;
    }

    public static void main(String[] args) {
        Main list = new Main();
        list.insert(1);
        list.insert(2);
        list.insert(3);
        list.insert(4);
        list.insert(5);
        list.insert(6);
        list.insert(7);
        list.display();

        list.segregateOddEven();
        list.display();
    }
}
