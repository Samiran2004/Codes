package Middle_Of_Linkedlist;

import java.util.Scanner;

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

        newNode.setNext(tail.getNext());
        tail.setNext(newNode);
        tail = newNode;
    }

    private void display() {
        if (head == null) {
            System.out.println("List is empty...");
            return;
        }

        Node currNode = head;
        while (currNode != null) {
            System.out.print(currNode.getData() + " --> ");
            currNode = currNode.getNext();
        }
        System.out.println("Null");
    }

    private int findMiddle() {
        if (head == null) {
            throw new Error("List is empty...");
        }
        if (head.getNext() == null) {
            return head.getData();
        }

        Node currNode = head;
        Node fastNode = head.getNext();

        while (fastNode != null && fastNode.getNext() != null) {
            currNode = currNode.getNext();
            fastNode = fastNode.getNext().getNext();
        }

        return currNode.getNext().getData();
    }

    public static void main(String[] args) {
        Main list = new Main();
        Scanner input = new Scanner(System.in);

        System.out.print("Enter how much data you want to insert: ");
        int size = input.nextInt();

        while (size > 0) {
            System.out.print("Enter data: ");
            int data = input.nextInt();
            list.insert(data);
            size--;
        }
        input.close();
        System.out.println("The list is: ");
        list.display();

        System.out.println("Middle element: " + list.findMiddle());
    }
}
