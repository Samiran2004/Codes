package Append_Nodes;

import java.util.Scanner;

public class Main {

    static Node head = null;
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

    private static int getSize() {
        int size = 0;
        Node currNode = head;
        while (currNode != null) {
            size++;
            currNode = currNode.next;
        }
        return size;
    }

    private void addNodes(int data, int position) {

        Node newNode = new Node(data);

        if (position < 0 || position > getSize()) {
            System.out.println("Invalid position, Please enter a valid position...");
            return;
        }

        if (position == 0) {
            newNode.next = head;
            head = newNode;

            if (tail == null) {
                tail = newNode;
            }
            return;
        }

        Node prevNode = head;
        for (int i = 1; i < position; i++) {
            prevNode = prevNode.next;
        }

        newNode.next = prevNode.next;
        prevNode.next = newNode;

        if (newNode.next == null) {
            tail = newNode;
        }
    }

    public static void main(String[] args) {
        Main list = new Main();
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the size of the linkedlist: ");
        int size = input.nextInt();

        while (size > 0) {
            System.out.print("Enter data: ");
            int data = input.nextInt();
            list.insert(data);
            size--;
        }

        list.display();

        System.out.print("Enter the data to be append: ");
        int appendData = input.nextInt();
        System.out.print("Enter the position: ");
        int position = input.nextInt();
        input.close();

        System.out.print("Updated list: ");
        list.addNodes(appendData, position);
        list.display();
    }
}
