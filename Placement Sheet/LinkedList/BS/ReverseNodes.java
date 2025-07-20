public class ReverseNodes {
    private Node head = null;
    private Node tail = null;

    private static class Node {
        int data;
        Node next;
        
        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    private void insert(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            tail = newNode;
            return;
        }
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
        System.out.println("NULL");
    }

    private Node reverseNodes(Node head, int k) {
        if (head == null || k == 1) {
            return head;
        }
        Node currNode = head;
        int count = 0;
        while (currNode != null && count < k) {
            currNode = currNode.next;
            count++;
        }
        if (count < k) {
            return head;
        }
        Node prevNode = null;
        Node nextNode = null;
        currNode = head;
        count = 0;
        while (currNode != null && count < k) {
            nextNode = currNode.next;
            currNode.next = prevNode;
            prevNode = currNode;
            currNode = nextNode;
            count++;
        }

        if (nextNode != null) {
            head.next = reverseNodes(nextNode, k);
        }
        return prevNode;
    }

    public void reverse(int k) {
        head = reverseNodes(head, k);
    }

    public static void main(String[] args) {
        ReverseNodes list = new ReverseNodes();
        list.insert(1);
        list.insert(2);
        list.insert(3);
        list.insert(4);
        list.insert(5);
        list.insert(6);
        
        System.out.println("Original List:");
        list.display();
        
        int k = 2;
        list.reverse(k);
        
        System.out.println("\nList after reversing in groups of " + k + ":");
        list.display();
    }
}