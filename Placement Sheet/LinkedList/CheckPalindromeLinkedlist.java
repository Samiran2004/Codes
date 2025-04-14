import java.util.Stack;

public class CheckPalindromeLinkedlist {
    public static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    private Node head = null;
    private int size = 0;

    // Insert...
    public void insert(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            size++;
            return;
        }
        Node currNode = head;
        while (currNode.next != null) {
            currNode = currNode.next;
        }
        currNode.next = newNode;
        size++;
    }

    // Display...
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
        System.out.println("Null");
    }

    public boolean isPalindrome() {
        if (head == null) {
            System.out.println("List is empty...");
            return false;
        }
        int[] values = new int[size];
        Node currNode = head;
        int index = 0;
        while (currNode != null) {
            values[index] = currNode.data;
            index++;
            currNode = currNode.next;
        }

        int startPtr = 0;
        int endPtr = values.length - 1;

        while (startPtr < endPtr) {
            if (values[startPtr] != values[endPtr]) {
                return false;
            }
            startPtr++;
            endPtr--;
        }
        return true;
    }

    public static void main(String[] args) {
        CheckPalindromeLinkedlist list = new CheckPalindromeLinkedlist();
        list.insert(1);
        list.insert(2);
        list.insert(3);
        list.insert(3);
        list.insert(2);
        list.insert(1);
        list.display();
        System.out.println("The list is palindrome: "+ list.isPalindrome());
    }
}
