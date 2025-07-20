public class AddTwoNumberRepByLinkedList {
    public static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    private Node head = null;
    private Node tail = null;

    // Insert...
    public void insert(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            tail = newNode;
            return;
        }
        Node currNode = head;
        while (currNode.next != null) {
            currNode = currNode.next;
        }
        currNode.next = newNode;
        tail.next = newNode;
        tail = newNode;
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

    public Node addTwoNumber(Node list1, Node list2) {
        Node dummyNode = new Node(0);
        Node currNode = dummyNode;
        int carry = 0;

        while (list1 != null || list2 != null || carry != 0) {
            int val1 = (list1 != null) ? list1.data : 0;
            int val2 = (list2 != null) ? list2.data : 0;

            int sum = val1 + val2 + carry;
            carry = sum / 10;

            currNode.next = new Node(sum % 10);
            currNode = currNode.next;

            if (list1 != null)
                list1 = list1.next;
            if (list2 != null)
                list2 = list2.next;
        }

        return dummyNode.next;
    }

    public static void main(String[] args) {
        AddTwoNumberRepByLinkedList list1 = new AddTwoNumberRepByLinkedList();
        list1.insert(1);
        list1.insert(2);
        list1.insert(3);
        System.out.print("List1: ");
        list1.display();

        AddTwoNumberRepByLinkedList list2 = new AddTwoNumberRepByLinkedList();
        list2.insert(5);
        list2.insert(4);
        list2.insert(3);
        System.out.print("List2: ");
        list2.display();

        AddTwoNumberRepByLinkedList result = new AddTwoNumberRepByLinkedList();
        result.head = result.addTwoNumber(list1.head, list2.head);
        System.out.print("Result: ");
        result.display();
    }
}