package Detect_And_Remove_Loop;

public class Main {
    Node head = null;
    Node tail = null;

    // private void insert(int data) {
    //     Node newNode = new Node(data);

    //     if (head == null) {
    //         head = newNode;
    //         tail = newNode;
    //         return;
    //     }
    //     newNode.next = tail.next;
    //     tail.next = newNode;
    //     tail = newNode;
    // }

    // private void display() {
    //     if (head == null) {
    //         System.out.println("List is empty...");
    //         return;
    //     }

    //     Node currNode = head;
    //     while (currNode != null) {
    //         System.out.println(currNode.data + " --> ");
    //         currNode = currNode.next;
    //     }
    //     System.out.println("Null");
    // }

    private static void display(Node head) {
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

    private static void detectLoopAndRemove(Node headNode) {
        if (headNode == null) {
            System.out.println("List is empty...");
            return;
        }
        if (headNode.next == null) {
            return;
        }

        Node slowPtr = headNode;
        Node fastPtr = headNode;

        boolean hasLoop = false;

        while (fastPtr != null && fastPtr.next != null) {
            slowPtr = slowPtr.next;
            fastPtr = fastPtr.next.next;

            if (slowPtr == fastPtr) {
                hasLoop = true;
                break;
            }
        }

        if (!hasLoop) {
            System.out.println("No loop detected...");
            return;
        }

        slowPtr = headNode;

        if(slowPtr == fastPtr) {
            while (fastPtr.next != slowPtr) {
                fastPtr = fastPtr.next;
            }
            fastPtr.next = null;
            return;
        }

        while (slowPtr.next != fastPtr.next) {
            slowPtr = slowPtr.next;
            fastPtr =fastPtr.next;
        }
        fastPtr.next = null;
    }

    public static void main(String[] args) {
        Node headNode = new Node(1);
        Node firstNode = new Node(2);
        headNode.next = firstNode;

        Node secNode = new Node(3);
        firstNode.next = secNode;

        Node thirdNode = new Node(4);
        secNode.next = thirdNode;

        Node fourthNode = new Node(5);
        thirdNode.next = fourthNode;

        Node fifthNode = new Node(6);
        fourthNode.next = fifthNode;

        Node sixNode = new Node(7);
        fifthNode.next = sixNode;

        Node sevNode = new Node(8);
        sixNode.next = sevNode;
        sevNode.next = secNode;

        detectLoopAndRemove(headNode);
        display(headNode);
    }
}
