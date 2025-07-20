package Reverse_A_LinkedList;

import java.util.Scanner;

public class Main {
    private static Node head;
    private static Node tail;

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
        System.out.println("NULL");
    }

    private static void reverseList() {
        if(head == null) {
            System.out.println("List is empty...");
            return;
        }

        Node prevNode = null;
        Node currNode = head;
        Node nextNode = null;
        tail = head;

        while (currNode != null) {
            nextNode = currNode.getNext();
            currNode.setNext(prevNode);
            prevNode = currNode;
            currNode = nextNode;
        }
        head = prevNode;
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

        System.out.print("Original List: ");
        list.display();
        System.out.print("Reversed List: ");
        list.reverseList();
        list.display();
    }
}
