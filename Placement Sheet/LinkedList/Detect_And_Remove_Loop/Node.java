package Detect_And_Remove_Loop;

public class Node {
    int data;
    Node next;

    Node() {
    };

    Node(int data) {
        this.data = data;
        this.next = null;
    }

    Node(int data, Node next) {
        this.data = data;
        this.next = next;
    }
}
